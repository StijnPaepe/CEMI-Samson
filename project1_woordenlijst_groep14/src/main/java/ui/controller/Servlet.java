package ui.controller;

import domain.db.Woordenlijst;
import domain.model.Woord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    Woordenlijst db = new Woordenlijst();

    public Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "download":
                destination = download(request, response);
                break;
            case "delete":
                destination = delete(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        db.verwijderVolgnummer(request.getParameter("volgnummer"));
        return overview(request, response);
    }

    private String download(HttpServletRequest request, HttpServletResponse response) {
        String filename = "woorden.txt";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Woord woord : db.getWoorden())
            out.println(woord.getWoord());
        out.close();
        return "overzicht.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String woordS = request.getParameter("woord");
        String niveau = request.getParameter("niveau");
        if (!woordS.isEmpty()) {
            Woord woord = new Woord(woordS, niveau);
            db.addWoord(woord);
            return overview(request, response);
        } else {
            return "voegToe.jsp";
        }
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("filter") == null) {
            request.setAttribute("alleWoorden", db.getWoorden());
        }
        else if (request.getParameter("filter").equals("beginner")) {
            request.setAttribute("alleWoorden", db.getWoordenBeginner());
        }
        else if (request.getParameter("filter").equals("expert")) {
            request.setAttribute("alleWoorden", db.getWoordenExpert());
        }
        return "overzicht.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("alleWoorden", db.getWoorden());
        if (db.getWoorden().size() > 0) {
            int aantalWoorden = db.getAantalWoorden();
            Woord langsteWoord = db.getLangsteWoord();
            Woord kortsteWoord = db.getKorsteWoord();
            double gemiddeld = db.gemiddeldVerschillendeLetters();

            request.setAttribute("aantalWoorden", aantalWoorden);
            request.setAttribute("langsteWoord", langsteWoord);
            request.setAttribute("kortsteWoord", kortsteWoord);
            request.setAttribute("gemiddeld", gemiddeld);
        }
        return "index.jsp";
    }
}
