<?php
include("sessionTimeout.php");
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Formularz</title>

</head>

<body>

    <div>
        <h1>Fromularz</h1>
    </div>
    <?php
    if (isset($_POST['login']) && isset($_POST['password']) && isset($_POST['name']) && isset($_POST['surname']) && isset($_POST['email']) && isset($_POST['phone'])) {
        $connection = mysqli_connect("localhost","root","","test");
        $sql = "INSERT INTO users (login, password, name, surname, email, phone) VALUES ('" . $_POST['login'] . "', '" . password_hash($_POST['password'], PASSWORD_DEFAULT) . "', '" . $_POST['name'] . "', '" . $_POST['surname'] . "', '" . $_POST['email'] . "', '" . $_POST['phone'] . "')";
        $result = mysqli_query($connection, $sql);
        if ($result) {
            echo "<br>Dodano użytkownika<br>";
        } else {
            echo "<br>Nie udało się dodać użytkownika<br>";
        }
    }
    else if (isset($_SESSION['login'])&&isset($_POST['password']) && isset($_POST['name']) && isset($_POST['surname']) && isset($_POST['email']) && isset($_POST['phone'])) {
        $connection = mysqli_connect("localhost","root","","test");
        $sql = "UPDATE users SET password = '" . password_hash($_POST['password'], PASSWORD_DEFAULT) . "', name = '" . $_POST['name'] . "', surname = '" . $_POST['surname'] . "', email = '" . $_POST['email'] . "', phone = '" . $_POST['phone'] . "' WHERE login = '" . $_SESSION['login'] . "'";
        $result = mysqli_query($connection, $sql);
        if ($result) {
            echo "<br>Zaktualizowano dane<br>";
        } else {
            echo "<br>Nie udało się zaktualizować danych<br>";
        }
    }



    if (!isset($_SESSION['login'])) {
        echo '<form action="form.php" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login">

        <label for="password">Hasło</label>
        <input type="password" id="password" name="password">

        <label for="name">Imię</label>
        <input type="text" id="name" name="name">

        <label for="surname">Nazwisko</label>
        <input type="text" id="surname" name="surname">

        <label for="email">Email</label>
        <input type="text" id="email" name="email">

        <label for="phone">Telefon</label>
        <input type="text" id="phone" name="phone">

        <button type="submit" id="but1">Submit</button>
        <button type="reset" id="but2">Reset</button>
    </form>';
    } else {
        echo "Zalogowany jako: " . $_SESSION['login'];
        //get data from database
        $connection = mysqli_connect("localhost", "root", "", "test");
        $sql = "SELECT * FROM users WHERE login = '" . $_SESSION['login'] . "'";
        $result = mysqli_query($connection, $sql);
        $row = mysqli_fetch_assoc($result);
        if (!$row) {
            echo "<br>Nie udało się pobrać danych<br>";
            die;
        }
        echo '<form action="form.php" method="post">

        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="adsfbnaoiudfs">

        <label for="name">Imię</label>
        <input type="text" id="name" name="name" value="' . $row['name'] . '">

        <label for="surname">Nazwisko</label>
        <input type="text" id="surname" name="surname" value="' . $row['surname'] . '">

        <label for="email">Email</label>
        <input type="text" id="email" name="email" value="' . $row['email'] . '">

        <label for="phone">Telefon</label>
        <input type="text" id="phone" name="phone" value="' . $row['phone'] . '">

        <button type="submit" id="but1">Submit</button>
        <button type="reset" id="but2">Reset</button>
    </form>';
    }

    ?>

<?php
    if (isset($_SESSION['login'])) {
        echo "<h1>Witaj " . $_SESSION['login'] . "</h1>";
        echo "<a href='logout.php'>Wyloguj</a><br>";
        echo "<a <a href='index.php'>Powrót do strony głównej</a>";

    }
    else{
        echo "Nie jesteś zalogowany (ale masz dostęp)<br>";
        echo "<a <a href='login.php'>Zaloguj się</a><br>";
        echo "<a <a href='index.php'>Powrót do strony głównej</a>";
    }
    
    
    ?>

</body>

</html>