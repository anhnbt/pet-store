package com.codegym.controller;

import com.codegym.dao.AdminDao;
import com.codegym.model.admin.Admin;
import com.codegym.utilities.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/administrator/login")
public class AdminLoginServlet extends HttpServlet {
    private AdminDao adminDao;

    @Override
    public void init() {
        Connection conn = DBConnection.getConnection();
        adminDao = new AdminDao(conn);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = adminDao.getLoggedCustomer(username, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            resp.sendRedirect("/administrator/customers");
        } else {
            session.setAttribute("msg", "<div class=\"alert alert-danger\">Invalid username or password</div>");
            resp.sendRedirect("/administrator/login");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("/admin/account/login.jsp").forward(req, resp);
        }
    }
}