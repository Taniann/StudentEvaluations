<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Student Evaluations Application</title>
</head>
<body>
    <center>
        <h1>Students</h1>
        <h2>
            <a href="/new">Add New Student</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Students</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Second name</th>
                <th>Middle name</th>
                <th>Kurs</th>
                <th>Grupa</th>
                <th>Study form</th>
                <th>Payment form</th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.first_name}" /></td>
                    <td><c:out value="${student.second_name}" /></td>
                    <td><c:out value="${student.middle_name}" /></td>
                    <td><c:out value="${student.kurs}" /></td>
                    <td><c:out value="${student.grupa}" /></td>
                    <td><c:out value="${student.study_form}" /></td>
                    <td><c:out value="${student.payment_form}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>