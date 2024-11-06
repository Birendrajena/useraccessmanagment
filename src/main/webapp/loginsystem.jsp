<html lang="en">
<head>
    
    <title>Form with Background Image</title>
    <style>
    body {
        margin: 30px;
        margin-top:100px;
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
   <center>
    <div class="form-container">
        <form action="LoginServlet" method="post">
            <h2>Log In</h2> 
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
           
            
           
           
            <button type="submit">Submit</button>
        </form>
    </div>
   </center>
    
    
</html>
