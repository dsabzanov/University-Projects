<?php
    session_start();
    require('dbconnection.php');
    require('item.php');

    if (isset($_GET['id'])) {
        $result = $db->query("SELECT * FROM products WHERE product_id=".$_GET['id']);
        $product = mysqli_fetch_object($result);
        
        $item = new item();
        $item->id = $product->product_id;
        $item->name = $product->display_name;
        $item->price = $product->price;
        $item->size = $product->size;
        $item->quantity = 1;
        
        $index = -1;
        $cart = unserialize(serialize($_SESSION['cart']));
        for ($i=0; $i<count($cart); $i++) {
            if ($cart[$i]->id == $_GET['id']) {
                $index = $i;
                break;
            }
        }
        if ($index == -1) {
            $_SESSION['cart'][] = $item;
        }
        else {
            $cart[$index]->quantity++;
            $_SESSION['cart'] = $cart;
        }
        
    }

if (isset($_GET['index'])) {
    $cart = unserialize(serialize($_SESSION['cart']));
    unset($cart[$_GET['index']]);
    $cart = array_values($cart);
    $_SESSION['cart'] = $cart;
    
}



?>




<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="normalize.css">
        

    </head>
    
    <body>
        <div class="container">
            <!-- Content here -->
                <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
                    <div class="container">
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <a class="navbar-brand" href="myorders.php">Tsarbucks</a>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-item nav-link" href="logout.php">Logout<span class="sr-only"></span></a>
                                <a class="nav-item nav-link" href="menu.php">Menu<span class="sr-only"></span></a>
                                <a class="nav-item nav-link" href="cart.php">Cart<span class="sr-only"></span></a>
                                <a class="nav-item nav-link" href="myorders.php">My Orders<span class="sr-only"></span></a>
                            </div>
                        </div>
                    </div>
                </nav>
            
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <h1>My Cart</h1>
                </div>
            </div>
            
            <?php
                if (isset($_GET['action'])) {
    
                    $result = $db->query("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");
                    $order_id = mysqli_fetch_object($result);
                    $order_id = $order_id->order_id + 1;

                    $user_id = 1;
                    $completed = 0;


                    $cart = unserialize(serialize($_SESSION['cart']));
                    for ($i=0; $i<count($cart); $i++) { 
                        $product_id = $cart[$i]->id;
                        $quantity = $cart[$i]->quantity;
                        if($db->query("INSERT INTO orders (order_id, user_id, product_id, quantity, completed) VALUES ('$order_id','$user_id', '$product_id','$quantity','$completed')")) {
                           //echo "New record successfully added into the person table";

                        }
                    }
                    //print_r($cart);
                    displayResult();
                    
                    
                    $cart = unserialize(serialize($_SESSION['cart']));
                    unset($cart);
                    $cart = array_values($cart);
                    $_SESSION['cart'] = $cart;
                    
                    
                    
                    //unset($cart);
                    //$cart = array();
                    
   
                    $db->close();
                    
                }
            
            
            
            
            
            
            
            
                function displayResult() {
                    if (isset($_SESSION['cart']) && empty($_SESSION['cart']) === FALSE) {
                        echo    "<div class=\"row\" id=\"confirmMsg\">
                                    <div class=\"col-2\">

                                    </div>
                                    <div class=\"col-8\">
                                        <div class=\"alert alert-success\" role=\"alert\">
                                            <strong>Congratulations!</strong> Your order has been successfully submitted!
                                        </div>
                                    </div>
                                </div>";
                    }
                    else {
                        echo    "<div class=\"row\" id=\"confirmMsg\">
                                    <div class=\"col-2\">

                                    </div>
                                    <div class=\"col-8\">
                                        <div class=\"alert alert-danger\" role=\"alert\">
                                            <strong>Uh Oh!</strong> Your cart is empty!
                                        </div>
                                    </div>
                                </div>";
                    }
                }
            ?>
                

            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <table class="table">
                        <thead>
                            <tr>
                                
                                <th>Product Name</th>
                                <th>Size (oz)</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                                $sumcost = 0;
                                $sumsize = 0;
                                $index = 0;
                                $cart = unserialize(serialize($_SESSION['cart']));
                                for ($i=0; $i<count($cart); $i++) {
                                    $sumcost += $cart[$i]->price * $cart[$i]->quantity;
                                    $sumsize += $cart[$i]->size * $cart[$i]->quantity;
                            ?>
                            <tr>
                                
                                <td class="col"><?php echo $cart[$i]->name; ?></td>
                                <td class="col"><?php echo $cart[$i]->size; ?></td>
                                <td class="col"><?php echo $cart[$i]->quantity; ?></td>
                                <td class="col">$<?php echo $cart[$i]->price * $cart[$i]->quantity; ?></td>
                                <td class="col"><a href="cart.php?index=<?php echo $index; ?>"><button class="btn btn-danger btn-sm">Remove</button></a></td>
                            </tr>
                            <?php 
                                    $index++;
                                }
                            ?>
                            <tr class="font-weight-bold">
                                <td>Total:</td>
                                <td><?php echo $sumsize; ?></td>
                                <td></td>
                                <td>$<?php echo $sumcost; ?></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <a class="nav-item nav-link" href="menu.php">
                                        <button class="btn btn-primary btn-sm">Continue Shopping</button>
                                    </a>
                                </td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <a class="nav-item nav-link" href="cart.php?action=submit">
                                        <button class="btn btn-success btn-sm">Submit Order</button>
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>


                        
        </div> <!-- END CONTAINER -->
        
        
    
        <!-- jQuery first, then Tether, then Bootstrap JS. -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        
        
    </body>
</html> 