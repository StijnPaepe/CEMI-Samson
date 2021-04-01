<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Woordenlijst</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="overzicht"/>
</jsp:include>
<main>
    <c:choose>
        <c:when test="${not empty alleWoorden}">
        <div class="table">
            <table>
                <thead>
                <tr>
                    <th>woord</th>
                    <th>niveau</th>
                    <th>verwijder</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="woord" items="${alleWoorden}">
                    <tr>
                        <td>${woord.woord}</td>
                        <td>${woord.niveau}</td>
                        <td><a href="Servlet?command=delete&volgnummer=${woord.volgnummer}">verwijder</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </c:when>
        <c:otherwise>
            <p>er zijn momenteel geen woorden.</p>
        </c:otherwise>
    </c:choose>
    <p><a href="Servlet?command=download">Download woordenlijst</a></p>
    <h2>Filters</h2>
    <ul>
        <li><a href="Servlet?command=overview">alles</a></li>
        <li><a href="Servlet?command=overview&filter=beginner">beginner</a></li>
        <li><a href="Servlet?command=overview&filter=expert">expert</a></li>
    </ul>
</main>
</body>
</html>
