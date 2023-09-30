<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-dashboard.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts Data</title>
</head>
<body>
    <h2>Active contacts</h2>
    <div id="table-container" tabindex="0">
        <table>
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Message</th>
                    <th scope="col">Archieve Query</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${ACTIVE_CONTACT_LIST}">
                    <c:url var="contactDetailsLink" value="requests">
                        <c:param name="command" value="archieve" />
                        <c:param name="fromTable" value="activecontacts" />
                        <c:param name="toTable" value="archievedcontacts" />
                        <c:param name="contactIdUnique" value="${contact.id}"/>
                    </c:url>
                    <tr>
                        <td>${contact.fullName}</td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                        <td>
                            <a href="${contactDetailsLink}">Archieve</a>
                        </td>
                        <td>View</td>
                    </tr>
                </c:forEach>
                <tr>
                    <th scope="row"></th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>

    <h2> Archieved Contacts</h2>

    <div id="table-container" tabindex="0">
        <table>
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Message</th>
                    <th scope="col">Update</th>
                    <th scope="col">view</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${ARCHIEVED_CONTACT_LIST}">
                    <tr>
                        <td>${contact.fullName}</td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                        <td>${contact.id}</td>
                        <td>View</td>
                    </tr>
                </c:forEach>
                <tr>
                    <th scope="row"></th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
