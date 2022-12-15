<?php
include("sessionTimeout.php");
include("requireLogin.php")
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Wylogowano</title>

</head>

<body>
    <div>
        <h1>Wylogowano</h1>
    </div>
    <a href="index.php">Wróć do strony głównej</a>
    <a href="login.php">Zaloguj się</a>

    <?php
        if (isset($_SESSION['login'])) {
            session_unset();

            session_destroy();
        }

?>

</body>

</html>