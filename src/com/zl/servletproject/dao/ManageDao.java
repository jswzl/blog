package com.zl.servletproject.dao;

import com.zl.servletproject.entity.Manage;

public interface ManageDao {
    public Manage select(String username);
}
