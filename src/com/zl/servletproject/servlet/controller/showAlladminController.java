package com.zl.servletproject.servlet.controller;

import com.zl.servletproject.entity.Admin;
import com.zl.servletproject.entity.Manage;
import com.zl.servletproject.service.AdminService;
import com.zl.servletproject.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(value = "/showAlladminController")
public class showAlladminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Manage manage = (Manage)session.getAttribute("manage");
        if(manage!=null){
            AdminService adminService = new AdminServiceImpl();
            List<Admin> adminList = adminService.showAllAdmin();
            req.setAttribute("admins",adminList);
            req.getRequestDispatcher("/showAlladminJSP").forward(req,resp);
        }else{
            resp.sendRedirect("/WebProject_war_exploded/Loginmg.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
