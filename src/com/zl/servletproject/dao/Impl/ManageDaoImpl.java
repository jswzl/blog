package com.zl.servletproject.dao.Impl;

import com.zl.servletproject.dao.ManageDao;
import com.zl.servletproject.entity.Manage;
import com.zl.servletproject.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManageDaoImpl implements ManageDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Manage select(String username) {
        try {
            Manage manage = queryRunner.query(DbUtils.getConnection(),"select * from manage where username=?;",new BeanHandler<Manage>(Manage.class),username);
            return manage;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
