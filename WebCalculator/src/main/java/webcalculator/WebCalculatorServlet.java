package webcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class WebCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Integer firstParameter;
        Integer secondParameter;
        String calculation;
        try {
            firstParameter = Integer.parseInt(req.getParameter("firstParam"));
            secondParameter = Integer.parseInt(req.getParameter("secondParam"));
            calculation = req.getParameter("calculation");
            resp.getWriter().println(calculate(firstParameter, secondParameter, calculation));
        } catch (Exception e) {
            resp.getWriter().println("Invalid arguments!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Integer firstParameter;
        Integer secondParameter;
        String calculation = req.getParameter("calculation");
        try {
            firstParameter = Integer.parseInt(req.getParameter("firstParam"));
            secondParameter = Integer.parseInt(req.getParameter("secondParam"));
            resp.getWriter().println(calculate(firstParameter, secondParameter, calculation));
        } catch (Exception e) {
            resp.getWriter().println("Invalid arguments!");
        }
    }

    private Integer calculate(Integer firstParam, Integer secondParam, String calculation){
        if (calculation.equals("+")){
            return firstParam + secondParam;
        } else {
            return  firstParam - secondParam;
        }
    }

}
