<?php
    require('dbconnection.php');
    session_start();

    if (isset($_POST['username']) && isset($_POST['password'])) {
        
        $username = $_POST['username'];
        $password = stripslashes($_POST['password']);
        $username = $db->real_escape_string($username);
        $password = $db->real_escape_string($password);
        $password = sha1($password);
        
        $query = "SELECT * FROM users WHERE username = '$username' and password='$password'";
        $result = $db->query($query) or die(mysqli_error());
 
        $rows = mysqli_num_rows($result);
        if ($rows == 1) {
            $query = "SELECT user_id FROM user_roles WHERE role = '$username'";
            $result = $db->query($query) or die(mysqli_error());
            $result = $result->fetch_assoc();
            if ($result["user_id"] == 1) {
                $_SESSION['username'] = $username; // Initializing Session
                $_SESSION['userid'] = $result["user_id"];
                //echo "loggedin";
                header("Location: myorders.php");
                exit();
            }
            if ($result["user_id"] == 2) {
                $_SESSION['username'] = $username; // Initializing Session
                $_SESSION['userid'] = $result["user_id"];
                //echo "loggedin";
                header("Location: pendingorders.php");
                exit();
            }
        } else {
            //echo "not loggedin";
            $error = "Username or Password is invalid";
        }
        $db->close();
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
                    
                    <a class="navbar-brand" href="#">Tsarbucks</a>
                    
                </nav>
            
            <div class="row justify-content-center">
                <div class="col-8 align-self-center">
                    <h1>Login</h1>
                </div>
            </div>
            <?php 
                if(isset($error)){ 
                    echo    "<div class=\"row justify-content-center\">
                                <div class=\"col-8 align-self-center\">
                                    <div class=\"alert alert-danger\" role=\"alert\">
                                        <strong>Uh Oh!</strong> $error!
                                    </div>
                                </div>
                            </div>"; 
                }
            ?>

            <div class="row justify-content-center">
                <div class="col-8 align-self-center">   
                    
                    
                    <form method="POST" action="index.php">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                        </div>
                       <button type="submit" name="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
                
            </div>
            
            
            
        </div> <!-- END CONTAINER -->
        
        
    
        <!-- jQuery first, then Tether, then Bootstrap JS. -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html> 