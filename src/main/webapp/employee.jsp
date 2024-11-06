<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.useraccesmanagement.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Access</title>
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
    <h2>Request Access to Software</h2>
  <center>
    <div class="form-container">
        <form action="SoftwareRequestServlet" method="post">
			<% List<Software> softwares = (List<Software>) request.getAttribute("availablesoftwares"); 
			   User user =(User)session.getAttribute("user"); %>
			   <input type="hidden" name="userId" value="<%=user.getId()%>">
            <label for="software">Select Software:</label>
            <select name="software_id" id="software" required>
              <% for(int i=0; i < softwares.size(); i++) {
				Software soft = softwares.get(0);
				 String name= soft.getName();
				 String id=soft.getId() +"";
				  %>
 				<option value="<%=id%>"><%=name%></option>              <% } %>
            </select><br>
    
            <label for="access_type">Access Type:</label>
            <select name="access_type" id="access_type" required>
                <option value="Read">Read</option>
                <option value="Write">Write</option>
                <option value="Admin">Admin</option>
            </select><br>
    
            <label for="reason">Reason for Request:</label>
            <textarea id="reason" name="reason" required></textarea><br>
    
            <button type="submit">Submit Request</button>
        </form>
    </div>
  </center>
   
</body>
</html>
