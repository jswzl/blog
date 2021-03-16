package com.zl.servletproject.service;

import com.zl.servletproject.entity.Manage;

public interface ManageService {
    public Manage Login(String username,String password);
}
