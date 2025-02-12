package controller;

import entity.Answer;
import entity.Phase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.PhaseRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StartServlet", value = "/creatServlet")
public class CreatServlet extends HttpServlet {

    private final PhaseRepository phaseRepository = PhaseRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Phase> newPhases = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String questionText = req.getParameter("questText" + i);
            String answer1 = req.getParameter("answer" + i + "_1");
            String answer2 = req.getParameter("answer" + i + "_2");
            if (i == 3) {
                if (questionText != null && answer1 != null && answer2 != null) {
                    Phase phase = new Phase(questionText, List.of(
                            new Answer(3, answer1),
                            new Answer(4, answer2)
                    ));
                    newPhases.add(phase);
                }
            }
            if (questionText != null && answer1 != null && answer2 != null) {
                Phase phase = new Phase(questionText, List.of(
                        new Answer(1, answer1),
                        new Answer(2, answer2)
                ));
                newPhases.add(phase);
            }
        }
        if (!newPhases.isEmpty()) {
            phaseRepository.addQuest(newPhases);
        }

        session.setAttribute("questNumber", 3);
        resp.sendRedirect("gameServlet");
    }
}
