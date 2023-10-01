<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-dashboard.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts Data</title>
</head>
<body>
    <div class="all-functions">
        <a href="${pageContext.request.contextPath}"> <button class="btn1">Home</button> </a>
    </div>
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
                    <c:url var="singleContactDetail" value="singlecontact">
                        <c:param name="full_name" value="${contact.fullName}" />
                        <c:param name="email" value="${contact.email}" />
                        <c:param name="message" value="${contact.message}" />
                        <c:param name="contactid" value="${contact.id}" />
                    </c:url>
                    <tr>
                        <td>${contact.fullName}</td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                        <td>
                            <a href="${contactDetailsLink}"><button id="linked-btn">Archieve</button></a>
                        </td>
                        <td>
                            <a href="${singleContactDetail}"><button id="linked-btn">View</button></a>
                        </td>
                    </tr>
                </c:forEach>
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
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${ARCHIEVED_CONTACT_LIST}">
                    <c:url var="contactDetailsLink" value="requests">
                        <c:param name="command" value="archieve" />
                        <c:param name="fromTable" value="archievedcontacts" />
                        <c:param name="toTable" value="activecontacts" />
                        <c:param name="contactIdUnique" value="${contact.id}"/>
                    </c:url>

                    <tr>
                        <td>${contact.fullName}</td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                        <td>
                            <a href="${contactDetailsLink}"><button id="linked-btn">Active</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
