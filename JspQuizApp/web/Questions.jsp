
<%@page import="quiz1.QuizHw"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions Page</title>
        <link href='styles.css' rel='stylesheet' />
    </head>
    <body>
        <%
            if (session.isNew()) {
                session.setAttribute("mytest", new QuizHw());
                session.setAttribute("counttimes", 1);
            }
            QuizHw test = (QuizHw) session.getAttribute("mytest");
            String userAns = null;
            if (test.getIndex() > 0) {
                userAns = request.getParameter("useranswer");
                int checkcount = (int) session.getAttribute("counttimes");
                if (Integer.parseInt(userAns) == QuizHw.getAnswers()[test.getIndex() - 1]) {
                    if (checkcount == 1) {
                        test.setResult(test.getResult() + 10);
                    } else if (checkcount == 2) {
                        test.setResult(test.getResult() + 5);
                        session.setAttribute("counttimes", 1);
                    } else if (checkcount == 3) {
                        test.setResult(test.getResult() + 2);
                        session.setAttribute("counttimes", 1);
                    } else {
                        test.setResult(test.getResult());
                        session.setAttribute("counttimes", 1);
                    }
                } else {
                    if (checkcount < 3) {
                        test.setIndex(test.getIndex() - 1);
                    }
                    checkcount++;
                    session.setAttribute("counttimes", checkcount);
                }
            }
            if (test.getIndex() < QuizHw.getQuestions().length) {
        %>

        <form method='post' action='Questions.jsp'>
            <h1>The Number Quiz</h1>
            <p>Your current score is  <%=test.getResult()%> </p>
            <p>Guess the next number in the sequence </p>
            <p> <%=QuizHw.getQuestions()[test.getIndex()]%> </p>
            Your answer: <input type='text' name='useranswer'/>
            <br/>
            <br/>

            <br/><br/><br/><input type='submit' value='Submit'/>
        </form>
        <%
                test.setIndex(test.getIndex() + 1);
            } else {
                out.print("<html><head><title>Quiz</title>"
                        + "<link href='styles.css' rel='stylesheet' ></head><body>");
                out.print("<div class='res'>");
                out.print("<h1>The Number Quiz</h1>");
                out.print("<p>Your current score is " + test.getResult() + " </p>");
                out.print("<p>You have completed the Number Quiz, with a score of " + test.getResult() + " out of " + (QuizHw.getAnswers().length * 10) + " </p>");
                out.print("</div>");
                out.print("</body></html>");
                session.invalidate();
            }
        %>

    </body>
</html>
