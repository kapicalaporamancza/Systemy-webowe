<?php
//wypisz wszystkie elementy tabeli users oraz umożliw filtrowanie danych
$connection = mysqli_connect("localhost","root","","test");
$sql = "SELECT * FROM users";
$result = mysqli_query($connection, $sql);

//filtrowanie po jednym z pól

$sql = "SELECT * FROM users WHERE 1=1";

if (isset($_POST['login']) && $_POST['login'] != '') {
    $sql .= " AND login = '" . $_POST['login'] . "'";
}
if (isset($_POST['name']) && $_POST['name'] != '') {
    $sql .= " AND name = '" . $_POST['name'] . "'";
}
if (isset($_POST['surname']) && $_POST['surname'] != '') {
    $sql .= " AND surname = '" . $_POST['surname'] . "'";
}
if (isset($_POST['email']) && $_POST['email'] != '') {
    $sql .= " AND email = '" . $_POST['email'] . "'";
}
if (isset($_POST['phone']) && $_POST['phone'] != '') {
    $sql .= " AND phone = '" . $_POST['phone'] . "'";
}

$result = mysqli_query($connection, $sql);

if (!$result) {
    echo mysqli_error($connection);
    die;
}
mysqli_close($connection);


echo '<form action="showtable.php" method="post">
    <label for="login">Login</label>
    <input type="text" id="login" name="login">
    <label for="name">Imię</label>
    <input type="text" id="name" name="name">
    <label for="surname">Nazwisko</label>
    <input type="text" id="surname" name="surname">
    <label for="email">Email</label>
    <input type="text" id="email" name="email">
    <label for="phone">Telefon</label>
    <input type="text" id="phone" name="phone">
    <button type="submit">Filtruj</button>
</form>';
echo '<table border="1">';
echo '<tr><th>id</th><th>login</th><th>password</th><th>name</th><th>surname</th><th>email</th><th>phone</th></tr>';
while ($row = mysqli_fetch_assoc($result)) {
    echo '<tr>';
    echo '<td>' . $row['id'] . '</td>';
    echo '<td>' . $row['login'] . '</td>';
    echo '<td>' . $row['password'] . '</td>';
    echo '<td>' . $row['name'] . '</td>';
    echo '<td>' . $row['surname'] . '</td>';
    echo '<td>' . $row['email'] . '</td>';
    echo '<td>' . $row['phone'] . '</td>';
    echo '</tr>';
}
echo '</table>';


?>