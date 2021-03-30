<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Student List</h1>

<br/><br/>
<div>
    <a class="btn btn-success"  href="${pageContext.request.contextPath}/add">Create Student</a>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <c:forEach  items="${students}" var ="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a class="btn btn-success"  href="${pageContext.request.contextPath}/edit/${student.id}">Edit</a>
                    <a class="btn btn-danger"  href="${pageContext.request.contextPath}/delete/${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>