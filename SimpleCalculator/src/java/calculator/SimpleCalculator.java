/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JP PC
 */
public class SimpleCalculator extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("<p>Please click the button</p>");
        out.print("<input type='submit' value='Click me'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
//            String numAdd1 = request.getParameter("numadd1");
//            String numAdd2 = request.getParameter("numadd2");
//            
//            String numMult1 = request.getParameter("nummult1");
//            String numMult2 = request.getParameter("nummult2");
//            
//            PrintWriter out = response.getWriter();
//            if (numAdd1.equals("") && !numAdd2.equals("")) {
//                numAdd1 = "0";
//            }
//            if (numAdd2.equals("") && !numAdd1.equals("")) {
//                numAdd2 = "0";
//            }
//            
//            if (numMult1.equals("") && !numMult2.equals("")) {
//                numAdd1 = "1";
//            }
//            
//            if (numMult2.equals("") && !numMult1.equals("")) {
//                numMult2 = "1";
//            }
//            
//            out.print("<html><head><title>Summation</title></head><body>");
//            if (!numAdd1.equals("") || !numAdd2.equals("")) {
//                out.print("<p>" + numAdd1 + " + " + numAdd2 + " = " + (Double.parseDouble(numAdd1) + Double.parseDouble(numAdd2)) + "</p>");
//            }
//            if (!numMult1.equals("") || !numMult2.equals("")) {
//                out.print("<p>" + numMult1 + " * " + numMult2 + " = " + (Double.parseDouble(numMult1) * Double.parseDouble(numMult2)) + "</p>");
//            }
//            out.print("</body></html>");

            //Improved Calculator
//            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            String inumAdd1 = request.getParameter("inumadd1");
            String inumAdd2 = request.getParameter("inumadd2");

            String inumMult1 = request.getParameter("inummult1");
            String inumMult2 = request.getParameter("inummult2");

            if (inumAdd1.equals("") && !inumAdd2.equals("")) {
                inumAdd1 = "0";
            }
            if (inumAdd2.equals("") && !inumAdd1.equals("")) {
                inumAdd2 = "0";
            }

            if (inumMult1.equals("") && !inumMult2.equals("")) {
                inumAdd1 = "1";
            }

            if (inumMult2.equals("") && !inumMult1.equals("")) {
                inumMult2 = "1";
            }

            double answer1 = 0;
            double answer2 = 0;
            if ((!inumAdd1.equals("") || !inumAdd2.equals("")) && !inumMult1.equals("") || !inumMult2.equals("")) {

                response.setContentType("text/html");
                answer1 = (Double.parseDouble(inumAdd1) + Double.parseDouble(inumAdd2));
                answer2 = (Double.parseDouble(inumMult1) * Double.parseDouble(inumMult2));
//                RequestDispatcher rd = request.getRequestDispatcher("index.html");
//                session.setAttribute("inumadd1", inumAdd1);
//                session.setAttribute("inumadd2", inumAdd2);
//                session.setAttribute("iaddanswer1", answer);
//                rd.include(request, response);

                out.print("<html><head><title>Summation</title></head><body>");
                out.print("<h1>Improved Calculator</h1>");
                out.print("<form action='SimpleCal' method='POST'><input type='text' name='inumadd1' value=" + inumAdd1 + "> + <input type='text' name='inumadd2' value=" + inumAdd2 + ">=<input type='text' value=" + answer1 + "><br/><br/>");
                out.print("<input type='text' name='inummult1' value=" + inumMult1 + "> + <input type='text' name='inummult2' value=" + inumMult2 + ">=<input type='text' value=" + answer2 + "><br/><br/>");

                out.print("<input type='submit' value='Calculate'/></form></body></html>");
            } else if ((!inumAdd1.equals("") || !inumAdd2.equals("")) && (inumMult1.equals("") && inumMult2.equals(""))) {
                answer1 = (Double.parseDouble(inumAdd1) + Double.parseDouble(inumAdd2));
                out.print("<html><head><title>Summation</title></head><body>");
                out.print("<form action='SimpleCal' method='POST'><input type='text' name='inumadd1' value=" + inumAdd1 + "> + <input type='text' name='inumadd2' value=" + inumAdd2 + ">=<input type='text' value=" + answer1 + "><br/><br/>");
                out.print("<input type='text' name='inummult1' value=''> + <input type='text' name='inummult2' value=''>=<input type='text' value=''><br/><br/>");
                out.print("<input type='submit' value='Calculate'/></form></body></html>");
            } else if ((inumAdd1.equals("") && inumAdd2.equals("")) && (!inumMult1.equals("") && !inumMult2.equals(""))) {
               answer2 = (Double.parseDouble(inumMult1) * Double.parseDouble(inumMult2));
                out.print("<html><head><title>Summation</title></head><body>");
                out.print("<form action='SimpleCal' method='POST'><input type='text' name='inumadd1' value=''> + <input type='text' name='inumadd2' value=''>=<input type='text' value=''><br/><br/>");
                out.print("<input type='text' name='inummult1' value=" + inumMult1 + "> + <input type='text' name='inummult2' value=" + inumMult2 + "/>=<input type='text' value=" + answer2 + "><br/><br/>");
                out.print("<input type='submit' value='Calculate'/></form></body></html>");
            } else {
                out.print("<html><head><title>Summation</title></head><body>");
                out.print("<form action='SimpleCal' method='POST'><input type='text' name='inumadd1' value=''> + <input type='text' name='inumadd2' value=''>=<input type='text' value=''><br/><br/>");
                out.print("<input type='text' name='inummult1' value=''> + <input type='text' name='inummult2' value=''>=<input type='text' value=''><br/><br/>");
                out.print("<input type='submit' value='Calculate'/></form></body></html>");
            }

//            if (!inumMult1.equals("") || !inumMult2.equals("")) {
//                response.setContentType("text/html");
//                double answer = (Double.parseDouble(inumMult1) * Double.parseDouble(inumMult2));
////                session.setAttribute("inummult1", inumMult1);
////                session.setAttribute("inummult2", inumMult2);
////                session.setAttribute("iaddanswer2", answer);
////                request.setAttribute("inummult1", session.getAttribute("inummult1"));
////                RequestDispatcher rd = request.getRequestDispatcher("index.html");
////                rd.include(request, response);
//                out.print("<html><head><title>Summation</title></head><body>");
//                out.print("</body></html>");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
