<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Woordenlijst</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
                    <th id="woord">woord</th>
                    <th id="niveau">niveau</th>
                    <th id="verwijder">verwijder</th>
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
            <article>
                <p>er zijn momenteel geen woorden.</p>
            </article>
        </c:otherwise>
    </c:choose>
    <article>
        <p><a href="Servlet?command=download">Download woordenlijst</a></p>
        <h2>Filters</h2>
        <ul>
            <li><a href="Servlet?command=overview">alles</a></li>
            <li><a href="Servlet?command=overview&filter=beginner">beginner</a></li>
            <li><a href="Servlet?command=overview&filter=expert">expert</a></li>
        </ul>
    </article>
</main>
</body>
</html>
