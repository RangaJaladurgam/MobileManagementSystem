<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap')
	;

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: "Lato", sans-serif;
}

body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 1rem;
	padding-block:2rem;
}

table {
	width: 70%;
	margin-bottom: 1rem;
}

table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

tr {
	height: 3rem;
}

td, th {
	padding-inline: 1rem;
}

/*tr:nth-child(even) {
	background: #99c3ffc2;
}
*/
.btn {
	text-align: center;
}

button {
	border: none;
	border-radius: 4px;
	padding: 6px 16px;
	margin: 2px;
}

button:hover,form input[type="submit"]:hover,form select {
	cursor: pointer;
}

#bt-1, #bt-2 {
	transition: all 0.5s ease-in-out;
}

#bt-1:hover,form input[type="submit"]:hover {
	background: green;
	color: white;
}

#bt-1 {
	border: 1px solid green;
	background: white;
	color: green;
}

#bt-2:hover {
	background: red;
	color: white;
}

#bt-2 {
	border: 1px solid red;
	background: white;
	color: red;
}

h1 {
	margin-top: 2rem;
	text-decoration: underline;
}

div {
	width: 70%;
	display: flex;
	justify-content: end;
}

div p {
	color: green;
	font-weight: 600;
}

form select, form input[type="text"] {
	height: 2rem;
	padding-inline: 1rem;
	border: 1px solid grey;
	border-radius: 5px;
}

section {
	width: 70%;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

form input[type="submit"] {
padding-inline:1.5rem;
	height: 2rem;
	border: 1px solid green;
	border-radius: 5px;
	color: green;
	font-weight: 600;
	font-size: 14px;
	background:white;
	transition:all 0.7s ease-in-out;
}



form select option {
	height: 2rem;
	font-size: 17px;
}

.searchBtn {
	display: flex;
	gap: 1rem;
}
</style>
</head>
</head>
<body>

	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	%>
	<h1>All Mobile Details</h1>
	<section>
		<form action="sort" method="GET">
			<select name="sortOrder" onchange="this.form.submit()">
				<option value="sort"
					<%="sort".equals(request.getAttribute("selectedSortOrder")) ? "selected" : ""%>>Sort
					By Price</option>
				<option value="lowToHigh"
					<%="lowToHigh".equals(request.getAttribute("selectedSortOrder")) ? "selected" : ""%>>Low-to-High</option>
				<option value="highToLow"
					<%="highToLow".equals(request.getAttribute("selectedSortOrder")) ? "selected" : ""%>>High-to-Low</option>
			</select>
		</form>
		<form action="searchBrand" class="searchBtn">
			<input type="text" placeholder="Enter brand" name="brand"> <input
				type="submit" value="SEARCH">
		</form>

	</section>

	<table>
		<tr>
			<th>Mobile ID</th>
			<th>Mobile Model</th>
			<th>Mobile Brand</th>
			<th>Mobile Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td class="btn"><a
				href="updateDetails?mobileId=<%=rs.getInt(1)%>"><button
						id="bt-1">UPDATE</button></a></td>
			<td class="btn"><a href="delete?mobileId=<%=rs.getInt(1)%>"><button
						id="bt-2">DELETE</button></a></td>
		</tr>
		<%
		}
		if (rs.next() == false) {
		%>
		<tr>
			<td colspan="6" style="text-align: center;">***************************
				End Of List ***************************</td>
		</tr>

		<%
		}
		%>

	</table>
	<a href="index.jsp"><button id="bt-1">Go back to Dashboard</button></a>
</body>
</html>