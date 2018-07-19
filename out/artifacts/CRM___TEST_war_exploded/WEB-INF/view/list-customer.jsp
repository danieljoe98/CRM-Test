<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 7/16/2018
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List of Customer</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
        <h2>This is list of Customers</h2>
        </div>
    </div>
        <div id="container">
            <div id="content">
                <%--Put add button : Add Customer --%>

                    <input type="button" value="Add Customer"
                           onclick="window.location.href='addForm'; return false;"
                            class="add-button"
                    />

                <%--add our html table here--%>
            <table>
                <tr>
                    <th>First Name:</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <%--Loop over and print our customers--%>

                <c:forEach var="tempCustomer" items="${customers}">
                <%--construct an "update" link with customer id --%>
                    <c:url var="updateLink" value="/customer/updateForm">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url><c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <%-- DISPLAY THE UPDATE LINK--%>
                                <a href="${updateLink}">Update</a>
                            |
                                <a href="${deleteLink}" onclick="if(!confirm('Are you sure want to delete this customer?')) return false">Delete</a>
                        </td>

                    </tr>
                </c:forEach>

            </table>
            </div>
        </div>



</body>
</html>
