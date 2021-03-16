package com.zl.servletproject.service.Impl;

import com.zl.servletproject.dao.Impl.ManageDaoImpl;
import com.zl.servletproject.dao.ManageDao;
import com.zl.servletproject.entity.Manage;
import com.zl.servletproject.service.ManageService;
import com.zl.servletproject.utils.DbUtils;

public class ManageServiceImpl implements ManageService {
    private ManageDao manageDao = new ManageDaoImpl();
    @Override
    public Manage Login(String username, String password) {
        Manage manage = null;
        try {
            DbUtils.begin();
            Manage temp = manageDao.select(username);
            if(temp!=null){
                if(temp.getPassword().equals(password)){
                    manage = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manage;
    }
}
