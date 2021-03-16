package com.zl.servletproject.servlet.controller;

import com.zl.servletproject.entity.Manage;
import com.zl.servletproject.service.Impl.ManageServiceImpl;
import com.zl.servletproject.service.ManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginmgController",value = "/loginmg")
public class LoginmgController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");
        String codes = (String)request.getSession().getAttribute("codes");
        if(!codes.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            ManageService manageService = new ManageServiceImpl();
            Manage manage = manageService.Login(username,password);
            if(manage!=null){
                HttpSession session = request.getSession();
                session.setAttribute("manage",manage);
                response.sendRedirect("/WebProject_war_exploded/showAlladminController");
            }else{
                response.sendRedirect("/WebProject_war_exploded/Loginmg.html");
            }
        }else{
            response.sendRedirect("/WebProject_war_exploded/Loginmg.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
