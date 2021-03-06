<?php
error_reporting(E_ALL);
$type = $_GET['type'];
switch ($type) {
    case "requestaccesstoken":
        requestAccessToken();
        break;
    case "dbstatus":
        getDBStatus();
        break;
    case "requestnewgame":
        requestNewGame();
        break;
    case "createuser":
        createUser();
        break;
    case "savegame":
        savegame();
        break;
    case "changepassword":
        changePassword();
        break;
    case "getstats":
        getStats();
        break;
    default:
        echo throwerror("Bad Request");
}
function throwerror($message)
{
    $default_error = ['status' => "Error", 'error_message' => $message];
    return json_encode($default_error);

}

function requestAccessToken()
{
    require 'dbconnection.php';
    $username = $_POST['username'];
    $password = $_POST['password'];

    if ($result = $conn->query("SELECT * FROM users WHERE username='$username'")) {
        $row = $result->fetch_assoc();
    }

    if (password_verify($password, $row["password"])) {
        $login = true;

        $accesstokenhash = bin2hex(random_bytes(16));
        $create = $conn->query("UPDATE users SET accesstoken = '$accesstokenhash' WHERE username = '$username';");

    } else {
        $login = false;
    }
    $data = ['status' => $login, 'accesstoken' => $accesstokenhash];
    echo json_encode($data);
}

function createUser()
{
    require 'dbconnection.php';
    $username = $_POST['username'];
    $password = $_POST['password'];
    $result = $conn->query("SELECT * FROM users WHERE username='$username'");
    if (empty($username) || empty($password)) {
        echo throwerror("Username or Password empty");
    } else {
        if ($result->num_rows === 0) {
            $hashedpw = password_hash($password, PASSWORD_DEFAULT);
            $create = $conn->query("INSERT INTO users (username, password) VALUES ('$username','$hashedpw')");
            if ($create = true) {
                $data = ['status' => "user_created"];
                echo json_encode($data);
            }

        } else {
            echo throwerror("User already exists");
        }
    }
}

function getDBStatus()
{
    require 'dbconnection.php';
    if (!$conn->connect_error) {

        $connectionstatus = ['dbconnection' => 'true'];
        echo json_encode($connectionstatus);
    } else {
        $connectionstatus = ['dbconnection' => 'false'];
        echo json_encode($connectionstatus);
    }
}

function requestNewGame()
{
    require 'dbconnection.php';

    $accesstoken = $_POST['accesstoken'];

    if ($resultcheck = $conn->query("SELECT * FROM users WHERE accesstoken = '$accesstoken'")) {
        $row1 = $resultcheck->fetch_assoc();
    }

    if ($row1['accesstoken'] == $accesstoken) {

        if ($result = $conn->query("SELECT * FROM images ORDER BY RAND() LIMIT 1")) {
            $row = $result->fetch_assoc();
        }

        $imagekey = $row["imagekey"];
        $coordinate1 = $row["coordinate1"];
        $coordinate2 = $row["coordinate2"];
        $username = $row1["username"];

        $conn->query("INSERT INTO games (username, coor1, coor2, imagekey) VALUES ('$username', '$coordinate1','$coordinate2', '$imagekey')");

        $data = ['status' => 'true', 'imagekey' => $imagekey, 'coordinate1' => $coordinate1, 'coordinate2' => $coordinate2];
        echo json_encode($data);

    } else {
        echo throwerror("Provided no or wrong accesstoken");
    }
}

function saveGame()
{
    require 'dbconnection.php';

    $accesstoken = $_POST['accesstoken'];
    $guessedcoor1 = $_POST['guessed_coor1'];
    $guessedcoor2 = $_POST['guessed_coor2'];
    $distance = $_POST['distance'];

    if ($resultcheck = $conn->query("SELECT * FROM users WHERE accesstoken = '$accesstoken'")) {
        $row1 = $resultcheck->fetch_assoc();

    }


    if ($row1['accesstoken'] == $accesstoken) {
        $username = $row1["username"];
        $conn->query("UPDATE games SET guessed_coor1='$guessedcoor1',guessed_coor2='$guessedcoor2',distance='$distance' WHERE username = '$username'");


        $data = ['status' => 'true', 'message' => "game saved"];
        echo json_encode($data);

    } else {
        echo throwerror("Provided no or wrong accesstoken");
    }
}

function changePassword()
{
    require 'dbconnection.php';

    $username = $_POST['username'];
    $oldpassword = $_POST['oldpassword'];
    $newpassword = $_POST['newpassword'];

    if ($result = $conn->query("SELECT * FROM users WHERE username='$username'")) {
        $row = $result->fetch_assoc();
    }

    if (password_verify($oldpassword, $row["password"])) {

        $hashedpw = password_hash($newpassword, PASSWORD_DEFAULT);
        $result = $conn->query("UPDATE users SET password='$hashedpw' WHERE username = '$username'");
        if ($result) {
            $data = ['status' => 'true', 'message' => "password changed"];
            echo json_encode($data);
        }
    } else {
        echo throwerror("Wrong password provided");
    }


}

function getStats()
{
    require 'dbconnection.php';

    $accesstoken = $_POST['accesstoken'];


    if ($result = $conn->query("SELECT * FROM users WHERE accesstoken='$accesstoken'")) {
        $row = $result->fetch_assoc();
        $username = $row["username"];
    }

    if ($accesstoken == $row["accesstoken"]) {


        $getstatsquery = $conn->query("SELECT gameid, imagekey, distance, time FROM games WHERE username='$username'");

        $jsonData = array();
        while ($array = $getstatsquery->fetch_row()) {
            $jsonData[] = $array;
        }
        echo json_encode($jsonData);


    }
}

?>