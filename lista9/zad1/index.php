<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>My test page</title>
    <style>
        <?php
            if (isset($_POST['fcolor']) && isset($_POST['fsize']) && isset($_POST['font']) && isset($_POST['bcolor'])) {
                setcookie("fcolor", $_POST['fcolor'], time() + 60);
                setcookie("fsize", $_POST['fsize'], time() + 60);
                setcookie("font", $_POST['font'], time() + 60);
                setcookie("bcolor", $_POST['bcolor'], time() + 60);
                
                echo "h1 {";
                    echo "color: " . $_POST['fcolor'] . ";";
                    echo "font-size: " . $_POST['fsize'] . "px;";
                    echo "font-family: " . $_POST['font'] . ";";
                    echo "}";
                echo "body {";
                    echo "background-color: " . $_POST['bcolor'] . ";";
                    echo "}";

            }
            else if (isset($_COOKIE['fcolor']) && isset($_COOKIE['fsize']) && isset($_COOKIE['font']) && isset($_COOKIE['bcolor'])) {
                echo "h1 {";
                echo "color: " . $_COOKIE['fcolor'] . ";";
                echo "font-size: " . $_COOKIE['fsize'] . "px;";
                echo "font-family: " . $_COOKIE['font'] . ";";
                echo "}";
                echo "body {";
                echo "background-color: " . $_COOKIE['bcolor'] . ";";
                echo "}";

            }
    
        ?>
    </style>

</head>

<body>
    
    <h1>Stylizacja czcionki</h1>
    <form action="index.php" method="post">
        <label for="fcolor">Color</label>
        <input type="color" id="fcolor" name="fcolor">

        <label for="fsize">Size</label>
        <input type="number" id="fsize" name="fsize" min="1" max="50" value="1">

        <label for="font">Font</label>
        <select id="font" name="font">
            <option value="arial">Arial</option>
            <option value="times">Times New Roman</option>
            <option value="courier">Courier</option>
            <option value="impact">Impact</option>
        </select>

        <br><br>
        <h1>Stylizacja tła</h1>

        <label for="bcolor">Color</label>
        <input type="color" id="bcolor" name="bcolor">

        <button type="submit" id="but1">Submit</button>
        <button type="reset" id="but2">Reset</button>
    </form>
    <br><br>

    <a href="diagnostic.php">Zawartość ciastka</a>

</body>

</html>