package ua.edu.nung.pz.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.edu.nung.pz.views.ContactView;
import ua.edu.nung.pz.views.IndexView;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactServlet", urlPatterns = "/contacts" )
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        IndexView indexView=IndexView.getInstance();
        String header = indexView.getHeader("");
        String footer = indexView.getFooter("");
        String contactForm = ContactView.getContactForm();
        String body = IndexView.getBody(header, footer, contactForm) ;

        out.println(IndexView.getInstance().getPage("Welcome to the Shop", body));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
