<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="studentmodel">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country:
		
		<form:select path="country">
		

			<form:options  items="${studentmodel.countryOptions }"/>
	
			
		</form:select>

		<br><br>
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

		<br><br>
		
		Operating Systems:
		
		<form:checkbox path="operatingSystems" value="Linux" />Linux
		<form:checkbox path="operatingSystems" value="Mac OS" />Mac OS 
		<form:checkbox path="operatingSystems" value="MS Window" />MS Windows 

		<br><br>
	
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>












