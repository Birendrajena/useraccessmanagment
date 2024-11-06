<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Software</title>
    <style>
        body {
            margin: 30px;
            padding: 30px;
            justify-content: center;
            align-items: center;
            background-image: url('https://cdn.wallpapersafari.com/92/72/lZxchw.jpg');
            background-size: cover;
            background-position: center;
            text-align: center;
        }

        .form-container {
            background-color: transparent;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 20px red;
            width: 300px;
            text-align: center;

        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 2px;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: green;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: green;
        }
    </style>
</head>
<body>
    <h2>Create New Software</h2>
    <center>
        <div class="form-container">
            <form action="SoftwareServlet" method="post">
                <label for="software_name">Software Name:</label>
                <input type="text" id="software_name" name="software_name" required><br>
        
                <label for="description">Description:</label>
                <textarea id="description" name="description" required></textarea><br>
        
                <label>Access Levels:</label><br>
                 Read<input type="radio" name="access_levels" value="Read"> 
                Write<input type="radio" name="access_levels" value="Write"> 
                Admin<input type="radio" name="access_levels" value="Admin"> <br>
        
                <button type="submit">Create Software</button>
            </form>
        </div>
    </center>
</body>
</html>
