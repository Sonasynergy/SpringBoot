<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${studentmodel.firstName} ${studentmodel.lastName}

<br><br>

The Country is : ${studentmodel.country}

<br><br>

Favorite Language: ${studentmodel.favoriteLanguage }

<br><br>

Operating Systems: 
<ul>
	<c:forEach var="temp" items="${studentmodel.operatingSystems}">
	<li>
	${temp }
	</li>
    </c:forEach>
</ul>

</body>

</html>







