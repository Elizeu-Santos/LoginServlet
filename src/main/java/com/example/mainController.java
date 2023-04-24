package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mainController extends HttpServlet {
    private static final String LOGIN_PAGE = "index.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final String WELCOME_PAGE = "bemvindo.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("loggedIn") == null) {
            request.setAttribute("errorMsg", "Você precisa fazer login para acessar esta página.");
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        } else {
            request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("admin")) {
            request.getSession().setAttribute("loggedIn", true);
            response.sendRedirect(WELCOME_PAGE);
        } else {
            request.setAttribute("errorMsg", "Usuário ou senha inválida.");
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }
}
