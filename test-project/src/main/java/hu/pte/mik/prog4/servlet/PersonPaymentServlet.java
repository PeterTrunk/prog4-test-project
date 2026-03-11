package hu.pte.mik.prog4.servlet;

import hu.pte.mik.prog4.model.Person;
import hu.pte.mik.prog4.service.IdProvider;
import hu.pte.mik.prog4.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PersonPaymentServlet extends HttpServlet {

    private final PersonService personService = new  PersonService();
    private final IdProvider idProvider = IdProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.createResponse(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String idNumber =  req.getParameter("idNumber");

        Person person = new Person(this.idProvider.nextId(), name, address, idNumber);

        this.personService.pay(person);
        this.createResponse(resp);



    }

    private void createResponse(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><meta charset=\"utf-8\"></head><body>");
        writer.println("<form method=\"post\">");
        writer.println("Name: <input type=\"text\" name=\"name\"/>");
        writer.println("Address: <input type=\"text\" name=\"address\"/>");
        writer.println("ID number: <input type=\"text\" name=\"idNumber\"/>");
        writer.println("<input type=\"submit\"/>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

}
