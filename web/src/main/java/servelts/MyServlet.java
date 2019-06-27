package servelts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        double firstOperand = 0;
        double secondOperand = 0;
        boolean noError = true;
        try {
            firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
            secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        } catch (Exception ex) {
            noError = false;
        }
        if (noError) {
            double result = 0;
            try {
                if (operation.equals("+")) result = functionSum(firstOperand, secondOperand);
                else if (operation.equals("-")) result = functionDif(firstOperand, secondOperand);
                else if (operation.equals("*")) result = functionMul(firstOperand, secondOperand);
                else if (operation.equals("/") && (secondOperand != 0))
                    result = functionDiv(firstOperand, secondOperand);
                else
                    noError = false;
            } catch (Exception ex) {
                noError = false;
            }
            if (noError) {
                doSetResult(response, String.valueOf(result));
                return;
            }
        }
        doSetError(response);
    }


    protected void doSetResult(HttpServletResponse response, String result) throws UnsupportedEncodingException, IOException {
        String reply = "{\"error\":0,\"result\":" + result + "}";
        response.getOutputStream().write(reply.getBytes("UTF-8"));
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doSetError(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        String reply = "{\"error\":1}";
        response.getOutputStream().write(reply.getBytes("UTF-8"));
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected double functionSum(double a, double b) {
        return a + b;
    }

    protected double functionDif(double a, double b) {
        return a - b;
    }

    protected double functionMul(double a, double b) {
        return a * b;
    }

    protected double functionDiv(double a, double b) {
        return a / b;
    }

}