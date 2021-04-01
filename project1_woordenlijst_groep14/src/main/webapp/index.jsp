<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Beheerapplicatie woordenlijst</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="home"/>
</jsp:include>
<p>Met deze applicatie kan je de woordenlijst beheren om in het spelletje Hangman te gebruiken.</p>
<h2>Statistieken</h2>
<c:choose>
    <c:when test="${not empty alleWoorden}">
        <p>Aantal woorden: ${aantalWoorden}</p>
        <p>Langste woord: ${langsteWoord.woord}</p>
        <p>Kortste woord: ${kortsteWoord.woord}</p>
        <p>Gemiddeld aantal verschillende letters van alle woorden: ${gemiddeld}</p>
    </c:when>
    <c:otherwise>
        <p>er zijn momenteel geen woorden.</p>
    </c:otherwise>
</c:choose>
</body>
</html>