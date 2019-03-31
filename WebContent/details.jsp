<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="POST">

	 <input type="hidden" name="id" value="${emp.id}">
		<input type="text" name="uname" value="${emp.username}" placeholder="uname"><br>
		
		 <input type="text" name="pass"  value="${emp.password}" placeholder="pass"><br>
		 
		  <input type="text" name="fname"  value="${emp.firstname}" placeholder="fname"><br> 
		  
			<input type="text" name="lname"  value="${emp.lastname}" placeholder="lname"><br> 
			
			<select name="gen" >
			<option value="Male"   ${emp.gender == 'Male' ? 'selected' : ''}>Male</option>
			<option value="Female" ${emp.gender == 'Female' ? 'selected' : ''}>Female</option>
		    </select><br> 
		
		<input type="text" name="mob" value="${emp.mob}" placeholder="phn"><br>
		
		<input type="submit" value="Update">
		
	</form>

</body>
</html>