<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>My test page</title>

</head>

<body>
    <div>
        <h1>Wylogowano</h1>
    </div>
    <a href="index.php">Wróć do strony głównej</a>
    <a href="login.php">Zaloguj się</a>

<?php
    session_start();    
    if (isset($_SESSION['login']) && isset($_SESSION['password'])) {
    session_destroy();
    }

?>

</body>

</html>