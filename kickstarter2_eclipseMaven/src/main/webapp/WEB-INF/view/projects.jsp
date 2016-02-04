<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects menu</title>
</head>
<body>
	Projects from category:
	<c:out value="${category}" />
	<c:forEach items="${projects}" var="project">


		
		<table>
			<tr>
				<td><c:out value="${project.name}" /></td>
				<td>
					<form name="ProjectForm" method="POST" action="controller">
						<input type="hidden" name="command" value="showProjectInfo" /> 
						<input type="hidden" name="project" value="${project.id}"> 
					 <input type="submit" value="ShowProjectInfo" />
					</form>
				</td>
				<td>	
					<form name="DeleteProjectForm" method="POST" action="controller">
						<input type="hidden" name="command" value="deleteProject" /> 
						<input type="hidden" name="project" value="${project.id}"> 
					 <input type="submit" value="DeleteProject" />
					</form>
				</td>
			</tr>
		</table>


	</c:forEach>
	<form name="AddProjectInCategory" action="controller" method="post">
		<input type="hidden" name="command" value="addProjectInCategory">
		Add project in
		<c:out value="${category}" />
		category<br /> 
		Name:<br> <input type="text" name="name" value=""><br>
		Description:<br> <input type="text" name="description" value=""><br>
		MoneyGot: <br> <input type="text" name="moneyGot" value=""><br>
		MoneyNeed: <br> <input type="text" name="moneyNeed" value=""><br>	
		DaysLeft: <br> <input type="text" name="daysLeft" value=""><br>
		<!-- <input type="hidden" name="user" value="${sessionScope.user.id}"> -->
		<input type="hidden" name="category" value="${category}"> 
		<input type="submit" value="ADD">
	</form>
		<form name="AddProjectInCategory" action="controller" method="post">
		<input type="hidden" name="command" value="addProjectInCategory">
		Add project in
		<c:out value="${category}" />
		category<br /> 
		Name:<br> <input type="text" name="name" value=""><br>
		Description:<br> <input type="text" name="description" value=""><br>
		MoneyGot: <br> <input type="text" name="moneyGot" value=""><br>
		MoneyNeed: <br> <input type="text" name="moneyNeed" value=""><br>	
		DaysLeft: <br> <input type="text" name="daysLeft" value=""><br>
		<!-- <input type="hidden" name="user" value="${sessionScope.user.id}"> -->
		<input type="hidden" name="category" value="${category}"> 
		<input type="submit" value="ADD">
	</form>

</body>
</html>