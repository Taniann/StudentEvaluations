<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Evaluations Application</title>
</head>
<body>
    <center>
        <h2>
            <a href="/list">List All Students</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Student`s score</h2></caption>
            <tr>
                <th>First name</th>
                <th>Second name</th>
                <th>Scores</th>
             </tr>
            <c:forEach var="student" items="${mapScore}">
            <tr>
                    <td><c:out value="${student.key.firstName}" /></td>
                    <td><c:out value="${student.key.secondName}" /></td>
                    <td><c:forEach var="entry" items="${student.value}">
                         <c:out value="${entry.key.name}"/>
                         <c:out value="${entry.value.value}"/>
                    </c:forEach></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>