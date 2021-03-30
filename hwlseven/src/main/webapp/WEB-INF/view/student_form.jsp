<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Student Form</h1>

<br/><br/>
<div>
    <form action="/add" method="post">
        <input type="hidden" name="id" value="${student.id}"/>
        <table>
            <tr><td>Name:</td><td>
                <input type="text" name="name" value="${student.name}"/></td></tr>
            <tr><td>Password:</td><td>
                <input type="text" name="age" value="${student.age}"/></td></tr>
            <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
        </table>
    </form>
</div>
</body>

</html>