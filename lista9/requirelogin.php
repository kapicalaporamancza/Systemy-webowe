<?php
if(!isset($_SESSION['login'])){

    echo "
    <!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='utf-8'>
    <title>Wylogowano</title>

</head>

<body>
Nie jesteś zalogowany
<a href='login.php'>Zaloguj się</a>
<a href='form.php'>Zarejestruj się</a>
</body>
</html>";
    die;
}