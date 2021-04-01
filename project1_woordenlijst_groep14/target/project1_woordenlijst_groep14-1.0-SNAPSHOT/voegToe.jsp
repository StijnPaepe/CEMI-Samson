<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Woord toevoegen</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="voegToe"/>
</jsp:include>
<main class="voegToe">
    <h2>Voeg een woord toe</h2>
    <form method="post" action="Servlet?command=add" novalidate>
        <label for="woord">Woord: </label>
        <input type="text" id="woord" name="woord" placeholder="woord">
        <label for="niveau">Niveau: </label>
        <select id="niveau" name="niveau">
            <option value="null"></option>
            <option value="beginner">beginner</option>
            <option value="expert">expert</option>
        </select>
        <input type="submit" value="verstuur" id="submit">
    </form>
</main>
</body>
</html>