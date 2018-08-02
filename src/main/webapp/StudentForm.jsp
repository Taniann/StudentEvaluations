<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
     <div align="center">
            <c:if test="${student != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${student == null}">
                <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                </c:if>
            <tr>
                <th>First name: </th>
                <td>
                    <input type="text" name="first_name" size="45"
                            value="<c:out value='${student.firstName}' />" />
                </td>
            </tr>
            <tr>
                <th>Second name: </th>
                <td>
                    <input type="text" name="second_name" size="45"
                            value="<c:out value='${student.secondName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Middle name: </th>
                <td>
                    <input type="text" name="middle_name" size="5"
                            value="<c:out value='${student.middleName}' />"
                    />
                </td>
            </tr>
           <tr>
                 <th>Kurs: </th>
                 <td>
                 <select name="selectedKurs">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5" >5</option>
                        <option value="6">6</option>
                    </select>
                 </td>
            </tr>
            <tr>
                 <th>Grupa: </th>
                <td><select name="selectedGroup">
                        <option value="TM-41">TM-41</option>
                        <option value="TM-31" >TM-31</option>
                        <option value="TR-51">TR-51</option>
                    </select></td>
            </tr>
            <tr>
                 <th>Study form: </th>
                <td><select name="selectedStudyForm">
                         <option value="full-time">full-time</option>
                         <option value="external">external</option>
                    </select></td>
            </tr>
            <tr>
                 <th>Payment form: </th>
                <td><select name="selectedPaymentForm">
                         <option value="free">free</option>
                         <option value="contract">contract</option>
                    </select></td>
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