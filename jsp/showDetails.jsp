<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Defect Details</title>
<link href="/css/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--In page style sheet: only for this page-->
<style>
div {
	width: 50%;
	border: 4px solid lightblue;
	border-radius: 25px;
	padding: 20px;
}
</style>
</head>
<body>
	<form action="UpdateDefect" method="POST">
	
	<!-- Passing applicationName and defectName as hidden characters -->
	
     	<input type="hidden" name="application" value=<%=request.getAttribute("application")%>>
     	<input type="hidden" name="defectName" value=<%=request.getAttribute("defectName")%>>
    
		<h1><%=request.getAttribute("application")%></h1>
		<h2>
			<span style="color: lightblue">Defect: <%=request.getAttribute("defectName")%>
			</span>
		</h2>
		<hr align="left" width="50%">
		<br></br>

		<div>
			<h3>Details:</h3>
			<hr align="left" width="100%">
			<label>Status: </label> <select name="status" required>
				<option selected="selected"><%=request.getAttribute("status")%></option>
				<option>open</option>
				<option>closed</option>
			</select> <br></br> <label>Priority: </label> <select name="priority" required>
				<option selected="selected"><%=request.getAttribute("priority")%></option>
				<option>Low</option>
				<option>Medium</option>
				<option>High</option>
			</select> <br></br> <label>Assignee: </label> <input type="text"
				name="assignee" value=<%=request.getAttribute("assignee")%>><br>

		</div>
		<br></br>
		<div>
			<h3>Description:</h3>
			<hr align="left" width="100%">
			<br></br>
			<textarea rows="4" cols="50" name="description"> 
	<%=request.getAttribute("description")%>
	</textarea>
			<br></br>
		</div>
		<br></br>
		<div>
			<h3>Summary:</h3>
			<hr align="left" width="100%">
			<br></br>
			<textarea rows="4" cols="50" name="summary" required> 
	<%=request.getAttribute("summary")%>
	</textarea>
			<br></br>
		</div>
		<br></br> 


		<button type="submit">Update Defect</button>
	</form>

<br></br> <a href="index.html">
			<button type="button">Go back to Main page</button>
		</a>

</body>
</html>
