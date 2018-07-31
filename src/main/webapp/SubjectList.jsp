<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Evaluations Application</title>
</head>
<body>
    <center>
        <h1>Subjects</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
        <h2>
            <a href="/list">List All Students</a>
        </h2>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="subject" items="${listSubject}">
                <tr>
                    <td><c:out value="${subject.id}" /></td>
                    <td><c:out value="${subject.name}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${subject.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${subject.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
           <div align="center">
           <c:if test="${subject != null}">
               <form action="update" method="post">
           </c:if>
           <c:if test="${subject == null}">
               <form action="addSubject" method="post">
           </c:if>
           <table border="1" cellpadding="5">
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${subject.id}' />" />
                </c:if>
            <tr>
                <th>First name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${subject.name}' />" />
                </td>
            </tr>
            </table>
              </form>
        </table>
    </div>
</body>
</html>