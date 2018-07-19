<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 7/16/2018
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">

        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <%--NEED TO ASSOCIATE THIS DATA WITH CUSTOMER ID--%>
            <form:hidden path="id" />
            <table>
                <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><label><form:input path="firstName"/></label></td>
                </tr>
                <tr>
                    <td><label>Last name:</label></td>
                    <td><label><form:input path="lastName"/></label></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><label><form:input path="email"/></label></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><label><input type="submit" value="Save" class="save"/></label></td>
                </tr>



                </tbody>
            </table>

        </form:form>

        <div stlye="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>

</body>
</html>
