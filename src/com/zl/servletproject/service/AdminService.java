package com.zl.servletproject.service;

import com.zl.servletproject.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String username, String password);

    public List<Admin> showAllAdmin();
}
