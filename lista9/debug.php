<?php
include("sessionTimeout.php");
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Debug</title>

</head>

<body>
    <div>
        <h1>DEBUG </h1>
    </div>
    <a href="index.php">Wróć do strony głównej</a>
    <a href="login.php">Zaloguj się</a>

<?php
    echo "<br>";
    echo $_SERVER['REQUEST_TIME'];
    echo "<br>";
    if(isset($_SESSION)){
        print_r($_SESSION);
    }
    echo "<br>";
    if(isset($_COOKIE)){
        print_r($_COOKIE);
    }
    echo "<br>";




?>

</body>

</html>