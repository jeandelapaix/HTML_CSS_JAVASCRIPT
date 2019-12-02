/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JP PC
 */
public class QuizServlet extends HttpServlet {

    private int index = 0;
    private HttpSession session = null;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        QuizHw test = new QuizHw();
        if (session == null) {
            session.invalidate();
            session = null;
        }
        session = request.getSession();
        session.setAttribute("myquiz", test);
        test.setResult(0);
        PrintWriter out = response.getWriter();
        if (index < QuizHw.getQuestions().length) {
            out.print("<html><head><title>Quiz</title>"
                    + "<link href='styles.css' rel='stylesheet' ></head><body>");
            out.print("<form method='post' action='QuizServ'>");
            out.print("<h1>The Number Quiz</h1>");
            out.print("<p>Your current score is "+test.getResult()+"</p>");
            out.print("<p>Guess the next number in the sequence </p>");
            out.print("<p>" + QuizHw.getQuestions()[index] + "</p>");
            out.print("Your answer: <input type='text' name='useranswer'/>");
            out.print("<br/><input type='submit' value='Submit'/>");
            out.print("</form>");
            out.print("</body></html>");

            index++;
        } else {
            session.invalidate();
            session = null;
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        QuizHw test = (QuizHw) session.getAttribute("myquiz");
        PrintWriter out = response.getWriter();
        int userAns = Integer.parseInt(request.getParameter("useranswer"));
        if (userAns == QuizHw.getAnswers()[index - 1]) {
            test.setResult(test.getResult() + 1);
        }
        if (index < QuizHw.getQuestions().length) {
            out.print("<html><head><title>Quiz</title>"
                    + "<link href='styles.css' rel='stylesheet' ></head><body>");
            out.print("<form method='post' action='QuizServ'>");
            out.print("<h1>The Number Quiz</h1>");
            out.print("<p>Your current score is " + test.getResult() + " </p>");
            out.print("<p>Guess the next number in the sequence </p>");
            out.print("<p>" + QuizHw.getQuestions()[index] + "</p>");
            out.print("Your answer: <input type='text' name='useranswer'/>");
            out.print("<br/><input type='submit' value='Submit'/>");
            out.print("</form>");
            out.print("</body></html>");

            index++;
        } else {
            out.print("<html><head><title>Quiz</title>"
                    + "<link href='styles.css' rel='stylesheet' ></head><body>");
            out.print("<div class='res'>");
            out.print("<h1>The Number Quiz</h1>");
            out.print("<p>Your current score is " + test.getResult() + " </p>");
            out.print("<p>You have completed the Number Quiz, with a score of " + test.getResult() + " out of " + QuizHw.getAnswers().length + " </p>");
            out.print("</div>");
            out.print("</body></html>");
            session.invalidate();
            session = null;
        }
    }
}
