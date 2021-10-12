/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author david
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] loginInfo = req.getParameterValues("loginInfo[]");
        boolean validated = false;
        String username = loginInfo[0];
        String password = loginInfo[1];
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        
        
        
        if (loginInfo != null && loginInfo.length == 2) {
            
            AccountService accountservice = new AccountService();
            User user = accountservice.login(username,password);
            if ( user != null) {
                validated = true;
            }
        }
        
        
        
        
        
        
        if (validated) {
            session.setAttribute("s_username", username);
            session.setAttribute("s_password", password);
            resp.sendRedirect("home");
            return;
        }
        else {
            req.setAttribute("message", "Incorrect login info. Please try again.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("s_username");
        
        if (username != null && req.getQueryString() == null) {
            resp.sendRedirect("home");
            return;
        }
        else if (req.getQueryString() != null && req.getQueryString().equals("logout")) {
            session.invalidate();
            req.setAttribute("message", "Successfully logged out!");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }
    
}
