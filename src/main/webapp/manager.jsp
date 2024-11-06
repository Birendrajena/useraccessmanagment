<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.useraccesmanagement.model.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pending Requests</title>
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

    .btn1:hover {
        background-color: green;
    }
    .btn2:hover{
        background-color: brown;
    }
</style>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <table>
        <thead>
            <tr>
                <th>Employee Name:</th>
                <th>Software Name:</th>
                <th>Access Type:</th>
                <th>Reason:</th>
                <th>Action:</th>
            </tr>
        </thead>
        <tbody>
			<% List<Request> pendingRequests = (List<Request>) request.getAttribute("pendingRequests"); 
						   User user =(User)session.getAttribute("user"); 
						   %>
					   <input type="hidden" name="userId" value="<%=user.getId()%>">
				<% for (int i=0;i <pendingRequests.size(); i++) { 
					Request req = pendingRequests.get(i); %>	   
            <tr>
                <td><%=req.getEmployeeName()%></td>
                <td><%=req.getSoftwareName()%></td>
                <td><%=req.getAccessType()%></td>
                <td><%=req.getReason()%></td>
                    
                    <td><center>
                        <div class="form-container">
                    <form action="ApprovalServlet" method="post">
                        <input type="hidden" name="request_id" value="<%=req.getId()%>">
                        <button class="btn1" type="submit" name="action" value="Approved">Approve</button>
                        <button class="btn2" type="submit" name="action" value="Rejected">Reject</button>
                    </form>
                        </div></center>
                </td>
            </tr>
			<% } %> 
        </tbody>
    </table>
</body>
</html>
