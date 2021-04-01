<header>
    <h1>HangMan</h1>
    <nav>
        <ul>
            <li ${param.actual eq 'home'?"id = actual":""}>
                <a href="Servlet?command=home">Home</a></li>
            <li ${param.actual eq 'overzicht'?"id = actual":""}>
                <a href="Servlet?command=overview">Toon woordenlijst</a></li>
            <li ${param.actual eq 'voegToe'?"id = actual":""}>
                <a href="voegToe.jsp">Nieuw woord</a></li>
        </ul>
    </nav>
</header>