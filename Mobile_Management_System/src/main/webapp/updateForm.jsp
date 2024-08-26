<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style>
div {
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: start;
	gap: 0.5rem;
}

form {
	margin-top: 5rem;
}
</style>
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	rs.next();
	%>
	<form action="update?mobileId=<%=rs.getInt(1)%>" method="post">
		<div>
			<label for="mobileId">Mobile Id:</label> <input type="number"
				placeholder="Enter Mobile ID" name="mobileId"
				value="<%=rs.getInt(1)%>" disabled>
		</div>
		<div>
			<label for="mobileModel">Mobile Model:</label> <input type="text"
				placeholder="Enter Mobile Model" name="mobileModel"
				value="<%=rs.getNString(2)%>">
		</div>
		<div>
			<label for="mobileBrand">Mobile Brand:</label> <input type="text"
				placeholder="Enter Mobile Brand" name="mobileBrand"
				value="<%=rs.getString(3)%>">
		</div>
		<div>
			<label for="mobilePrice">Mobile Price:</label> <input type="number"
				placeholder="Enter Mobile Price" name="mobilePrice"
				value="<%=rs.getInt(4)%>">
		</div>
		<input type="submit" value="UPDATE" style="color:white;font-weight:600;">
	</form>
</body>
</html>