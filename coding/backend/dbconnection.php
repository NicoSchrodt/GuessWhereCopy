<?php
$conn = new mysqli("localhost","guesswhere","< Password here>","data");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
