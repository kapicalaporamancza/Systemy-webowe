<?php
include("sessionTimeout.php");
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>My test page</title>

</head>

<body>

    <div>
        <h1>Zaloguj się</h1>
    </div>
    <form action="login.php" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login">

        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        </select>

        <button type="submit" id="but1">Submit</button>
        <button type="reset" id="but2">Reset</button>
    </form>

    <?php
    if (isset($_POST['login']) && isset($_POST['password'])) {
        if ($_POST['login'] == "admin" && $_POST['password'] == "admin") {
            $_SESSION['login'] = $_POST['login'];
            $_SESSION['password'] = $_POST['password'];
            $_SESSION['TIMEOUT'] = $_SERVER['REQUEST_TIME'] + 120;
            header("Location: index.php");
        } else {
            echo "Zły login lub hasło";
        }
    }
    ?>

    <a href="index.php">Wróć do strony głównej</a>
    <a href="logout.php">Wyloguj się</a>

</body>

</html>