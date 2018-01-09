<?php
    session_start();
    if(!isset($_SESSION["username"])) {
        header("Location: index.php");
        exit(); 
    }
    require('dbconnection.php');
    //require('item.php');
    


    if(isset($_GET['action'])) {
        $orderid = $_GET['orderid'];
        $productid = $_GET['productid'];
        if($db->query("UPDATE orders SET completed = 1 WHERE order_id = '$orderid' AND product_id = '$productid'")) {
            header("Location: pendingorders.php");
            exit();
        }
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
                        <a class="navbar-brand" href="pendingorders.php">Tsarbucks</a>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-item nav-link" href="logout.php">Logout<span class="sr-only"></span></a>
                                <a class="nav-item nav-link" href="pendingorders.php">Pending Orders<span class="sr-only">(current)</span></a>
                            </div>
                        </div>
                    </div>
                </nav>
            
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <h1>Pending Orders</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <?php 
                        $query1 = "SELECT * FROM orders ORDER BY orders.order_id DESC";
                        $result = $db->query($query1);
                        $greatestId = $result->fetch_array();
                        $greatestId = $greatestId['order_id']; //7
                        //echo $greatestId;    
                    
                        $result->close();
                    
                        
                        while ($greatestId > 0) {
                            
                           
                    
                        $query2 = "SELECT orders.order_id, products.product_id, orders.completed, products.display_name, products.price, products.size, orders.quantity, orders.quantity * price AS ExtPrice FROM products INNER JOIN orders ON products.product_id = orders.product_id WHERE  orders.order_id=". $greatestId;
                        $products = $db->query($query2);
                        
                        $results = array();
                    

                        
                        while($line = mysqli_fetch_assoc($products)) {
                            $results[] = $line; 
                        }

                        
                    ?>
                    <h3>Order <?php echo $greatestId ?></h3>
                    
                    <table class="table">
                        <thead>
                            
                            <tr>     
                                <th>Product Name</th>
                                <th>Size (oz)</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Status</th>
                            </tr>
                        </thead>

                        <tbody>
                            <?php
                                $sumcost = 0;
                                $sumsize = 0;
                                foreach ( $results as $var ) {
                                        $sumcost += $var['price'] * $var['quantity'];
                                        $sumsize += $var['size']  * $var['quantity'];
                            ?>
                            
                            <tr>
                                <td class="col-6"><?php echo $var['display_name'] ?></td>
                                <td><?php echo $var['size'] ?></td>
                                <td><?php echo $var['quantity']; ?></td>
                                <td>$<?php echo $var['ExtPrice'] ?></td>
                                <td>
                                    <?php 
                                        if ($var['completed'] == 0) {
                                    ?>
                                            <a href="pendingorders.php?action=updateorders&orderid=<?php echo $var['order_id'] ?>&productid=<?php echo $var['product_id'] ?>" >
                                                <button type="button" class="btn btn-primary btn-sm">Mark Complete</button>
                                            </a>
                                    <?php
                                        }
                                        else {
                                    ?>
                                            <span class="badge badge-success">Completed</span>
                                    <?php
                                        } 
                                    ?>
                                </td>
                            </tr>   
                            <?php 
                                }     
                            ?>
                            <tr class="font-weight-bold">
                                <td>Total:</td>
                                <td><?php echo $sumsize; ?> oz</td>
                                <td></td>
                                <td>$<?php echo $sumcost; ?></td>
                                <td></td>
                            </tr>
                            
                        </tbody>
                    </table>
                    <?php
                                $products->close();
                                $greatestId = $greatestId - 1;
                            } 
                    ?>
                </div>
            </div>


                        
        </div> <!-- END CONTAINER -->
        
        
    
        <!-- jQuery first, then Tether, then Bootstrap JS. -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html> 