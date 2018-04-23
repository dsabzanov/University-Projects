<?php
    session_start();
    if(!isset($_SESSION["username"])) {
        header("Location: index.php");
        exit(); 
    }
    require('dbconnection.php');

    $result = $db->query("SELECT * FROM products");
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
                                <a class="nav-item nav-link" href="menu.php">Menu<span class="sr-only">(current)</span></a>
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
                    <h1>Menu</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Size (oz)</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php while($product = mysqli_fetch_object($result)) { ?>
                            <tr>
                                <td><?php echo $product->display_name; ?></td>
                                <td>$<?php echo $product->price; ?></td>
                                <td><?php echo $product->size; ?></td>
                                <td><a href="cart.php?id=<?php echo $product->product_id; ?>"><button class="btn btn-primary">Add to Cart</button></a></td>
                            </tr>
                            <?php 
                                }
                                $db->close();
                            ?>
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