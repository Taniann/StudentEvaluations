<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Evaluations Application</title>
</head>
<body>
    <center>
        <h1>Student`s scores</h1>
     <div align="center">
     <c:if test="${score == null}">
       <form action="insertScore" method="post">
                </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${score != null}">
                    <input type="hidden" name="id" value="<c:out value='${score.id}' />" />
                </c:if>
            <tr>
                <th>Value: </th>
                <td>
                    <input type="number" name="value" size="45"
                            value="<c:out value='${score.value}' />" />
                </td>
            </tr>
            <tr>
                <th>Student id: </th>
                <td>
                    <input type="number" name="id_student" size="45"
                            value="<c:out value='${score.idStudent}' />" />
                </td>
            </tr>
            <tr>
                <th>Subject name: </th>
                <td>
                    <input type="text" name="name_subject" size="45"
                            value="<c:out value='${score.subjectName}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>