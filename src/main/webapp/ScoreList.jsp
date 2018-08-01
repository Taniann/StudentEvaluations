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
                <th>Middle name</th>
                <th>Scores</th>
            </tr>
            <c:forEach var="student" items="${listScore}">
                <tr>
                    <td><c:out value="${student.firstName}" /></td>
                    <td><c:out value="${student.secondName}" /></td>
                    <td><c:out value="${student.middleName}" /></td>
                    <td><c:forEach var="entry" items="${student.finalResult}">
                          Subject: <c:out value="${entry.key}"/>
                          Value: <c:out value="${entry.value}"/>
                        </c:forEach></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>