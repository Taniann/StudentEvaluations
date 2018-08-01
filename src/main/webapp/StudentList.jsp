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
            &nbsp;&nbsp;&nbsp;
            <a href="/listSubject">List of Subjects</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listScores">List of Scores</a>
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
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.firstName}" /></td>
                    <td><c:out value="${student.secondName}" /></td>
                    <td><c:out value="${student.middleName}" /></td>
                    <td><c:out value="${student.kurs}" /></td>
                    <td><c:out value="${student.group}" /></td>
                    <td><c:out value="${student.studyForm}" /></td>
                    <td><c:out value="${student.paymentForm}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${student.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${student.id}' />">Delete</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/addScores?id=<c:out value='${student.id}' />">Add scores</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
        <table cellpadding="5">
                <form method="post" action="filter" commandName="somedata">
                <tr>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td>
                <td>Please select just one option :)</td>
                <td><select name="selectedKurs">
                        <option selected="selected" value="all" >all</option>
                        <option value="1">1</option>
                        <option value="2" >2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                    </select></td>
                <td><select name="selectedGroup">
                        <option selected="selected" value="all" >all</option>
                        <option value="TM-41">TM-41</option>
                        <option value="TM-31" >TM-31</option>
                        <option value="TM-51">TR-51</option>
                    </select></td>
                <td><select name="selectedStudyForm">
                         <option selected="selected" value="all" >all</option>
                         <option value="full-time">full-time</option>
                         <option value="external" >external</option>
                    </select></td>
                <td><select name="selectedPaymentForm">
                         <option selected="selected" value="all">all</option>
                         <option value="free">free</option>
                         <option value="contract">contract</option>
                    </select></td>
                <td></td>
                <td colspan="2" align="center">
                    <input type="submit" value="Filter" />
                </td>
            </tr>
        </table>
        </form>
</body>
</html>