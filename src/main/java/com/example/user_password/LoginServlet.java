package com.example.user_password;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String LOGIN_ERROR_MSG = "Usuário ou senha inválida.";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            request.getSession().setAttribute("loggedIn", true);
            response.sendRedirect("bemvindo.jsp");
        } else {
            request.setAttribute("errorMsg", LOGIN_ERROR_MSG);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
