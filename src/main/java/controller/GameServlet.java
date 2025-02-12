package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.PhaseGame;

import java.io.IOException;

@WebServlet(name = "GameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        PhaseGame game = (PhaseGame) session.getAttribute("gameState");

        String questParam = req.getParameter("quest");
        if (questParam != null) {
            int questNumber = Integer.parseInt(questParam);
            session.setAttribute("questNumber", questNumber);
            session.removeAttribute("gameState");
        }
//        if (questParam != null) {
//            int questNumber = Integer.parseInt(questParam);
//            session.setAttribute("questNumber", questNumber);
//        }

        Integer questNumber = (Integer) session.getAttribute("questNumber");
        PhaseGame game = (PhaseGame) session.getAttribute("gameState");
        if (game == null || questParam != null) {
            game = new PhaseGame(questNumber);
            session.setAttribute("gameState", game);
        }
//        if (game == null) {
//            game = new PhaseGame(questNumber);
//            session.setAttribute("gameState", game);
//        }


        String name = req.getParameter("userName");
        if (name != null && !name.trim().isEmpty()) {
            session.setAttribute("userName", name);
        }
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 1;
            session.setAttribute("counter", counter);
        }
        req.setAttribute("phase", game.startGame());
        req.setAttribute("text", game.startGame().getText());
        req.setAttribute("answer1", game.startGame().getAnswers().get(0));
        req.setAttribute("answer2", game.startGame().getAnswers().get(1));
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PhaseGame game = (PhaseGame) session.getAttribute("gameState");

        int answerIndex = Integer.parseInt(req.getParameter("answerId"));
        game.nextPhase();
        switch (answerIndex) {
            case 1 -> {
                resp.sendRedirect("gameServlet");
            }
            case 2 -> {
                game.losePhase();
                resp.sendRedirect("gameServlet");
            }
            case 3 -> {
                game.reviewPhase();
                resp.sendRedirect("gameServlet");
            }
            case 4 -> {
                game.restartPhase();
                Integer counter = (Integer) session.getAttribute("counter");
                session.setAttribute("counter", counter + 1);
                session.removeAttribute("username");
                session.removeAttribute("questNumber");

//                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                resp.sendRedirect("index.jsp");
            }
            case 5 -> {
                game.restartPhase();
                resp.sendRedirect("quest.jsp");
            }
            default -> resp.sendRedirect("error.html");
        }
    }
}
