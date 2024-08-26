<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Enter Mobile Details</h1>
	<form action="add-mobile" method="post">
		<input type="number" placeholder="Enter Mobile ID" name="mobileId">
		<input type="text" placeholder="Enter Mobile Model" name="mobileModel">
		<input type="text" placeholder="Enter Mobile Brand" name="mobileBrand">
		<input type="number" placeholder="Enter Mobile Price" name="mobilePrice"> 
		<input type="submit" value="ADD">
	</form>
</body>
</html>