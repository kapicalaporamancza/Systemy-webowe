<?php
include("sessionTimeout.php");
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>My test page</title>
    <style>
        <?php
if (isset($_POST['color']) && isset($_POST['size']) && isset($_POST['font'])) {
            setcookie("color", $_POST['color'], time() + 60);
            setcookie("size", $_POST['size'], time() + 60);
            setcookie("font", $_POST['font'], time() + 60);
            echo "h1 {";
                echo "color: " . $_POST['color'] . ";";
                echo "font-size: " . $_POST['size'] . "px;";
                echo "font-family: " . $_POST['font'] . ";";
                echo "}";
        }
        else if (isset($_COOKIE['color']) && isset($_COOKIE['size']) && isset($_COOKIE['font'])) {
            echo "h1 {";
            echo "color: " . $_COOKIE['color'] . ";";
            echo "font-size: " . $_COOKIE['size'] . "px;";
            echo "font-family: " . $_COOKIE['font'] . ";";
            echo "}";
        }
    
        ?>
    </style>

</head>

<body>
    <?php
    if (isset($_SESSION['login']) && isset($_SESSION['password'])) {
        echo "<h1>Witaj " . $_SESSION['login'] . "</h1>";
        echo "<a href='logout.php'>Wyloguj</a>";
    }
    else{
        echo "Nie jesteś zalogowany<br>";
        echo "<a <a href='login.php'>Zaloguj się</a>";
        die;
    }
    
    
    ?>
    <div>
        <h1>Przykładowy tekst w nagłówku w divie</h1>
    </div>
    <form action="index.php" method="post">
        <label for="color">Color</label>
        <input type="color" id="color" name="color">

        <label for="size">Size</label>
        <input type="number" id="size" name="size" min="0" max="50" value="0">

        <label for="font">Font</label>
        <select id="font" name="font">
            <option value="arial">Arial</option>
            <option value="times">Times New Roman</option>
            <option value="courier">Courier</option>
    </select>

        <button type="submit" id="but1">Submit</button>
        <button type="reset" id="but2">Reset</button>
    </form>
    <a href="logout.php">Wyloguj się</a>



</body>

</html>