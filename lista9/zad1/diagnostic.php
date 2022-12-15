<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>My test page</title>

    <style>
        <?php
            if (isset($_COOKIE['fcolor']) && isset($_COOKIE['fsize']) && isset($_COOKIE['font']) && isset($_COOKIE['bcolor'])) {
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
    <div>
        <h1>Diagnostic page </h1>
    </div>
    <br><br>
    <?php
    if (isset($_COOKIE['fcolor']) && isset($_COOKIE['fsize']) && isset($_COOKIE['font']) && isset($_COOKIE['bcolor'])) {
        echo "<br><br>";
        echo $_COOKIE['fcolor'] . "<br>";
        echo $_COOKIE['fsize']. "<br>";
        echo $_COOKIE['font']. "<br>";
        echo $_COOKIE['bcolor']. "<br>";
    } else {
        echo "No style selected <br> &_COOKIE array: <br>" ;
        echo implode(", ", $_COOKIE);
    }
?>
    <br><br>
    <a href="index.php">Wróć do strony głównej</a>


</body>

</html>