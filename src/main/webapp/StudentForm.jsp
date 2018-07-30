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
    </center>
    <div align="center">
           <c:if test="${student != null}">
               <form action="update" method="post">
           </c:if>
           <c:if test="${student == null}">
               <form action="insert" method="post">
           </c:if>
           <table border="1" cellpadding="5">
               <caption>
                   <h2>
                       <c:if test="${student != null}">
                           Edit Student
                       </c:if>
                       <c:if test="${student == null}">
                           Add New Student
                       </c:if>
                   </h2>
               </caption>
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                </c:if>
            <tr>
                <th>First name: </th>
                <td>
                    <input type="text" name="first_name" size="45"
                            value="<c:out value='${student.first_name}' />" />
                </td>
            </tr>
            <tr>
                <th>Second name: </th>
                <td>
                    <input type="text" name="second_name" size="45"
                            value="<c:out value='${student.second_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Middle name: </th>
                <td>
                    <input type="text" name="middle_name" size="5"
                            value="<c:out value='${student.middle_name}' />"
                    />
                </td>
            </tr>
           <tr>
                 <th>Kurs: </th>
                 <td>
                    <input type="number" name="kurs" size="5"
                             value="<c:out value='${student.kurs}' />"
                     />
                 </td>
            </tr>
            <tr>
                 <th>Grupa: </th>
                 <td>
                    <input type="text" name="grupa" size="5"
                             value="<c:out value='${student.grupa}' />"
                     />
                 </td>
            </tr>
            <tr>
                 <th>Study form: </th>
                 <td>
                    <input type="text" name="study_form" size="5"
                             value="<c:out value='${student.study_form}' />"
                     />
                 </td>
            </tr>
            <tr>
                 <th>Middle name: </th>
                 <td>
                    <input type="text" name="payment_form" size="5"
                             value="<c:out value='${student.payment_form}' />"
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