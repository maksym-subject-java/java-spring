package ua.edu.nung.pz.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.edu.nung.pz.views.IndexView;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart/*"})
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String context = "<h2>Cart!</h2>\n";

        String body = IndexView.getInstance().getBody(
                IndexView.getInstance().getHeader(""),
                IndexView.getInstance().getFooter(""),
                context
        );

        out.println(IndexView.getInstance().getPage("Green Shop", body));
    }
}
