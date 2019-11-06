package com.flying.service.com.flying.service.impl;

import com.flying.entity.Test;
import com.flying.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getList() {
        String sql = "select id, cdate from test";
        return (List)jdbcTemplate.query(sql, new RowMapper() {
            public Test mapRow(ResultSet rs, int i) throws SQLException {
                Test test = new Test();
                test.setID(rs.getString("id"));
                //test.setCDate(rs.getDate();
                return test;
            }
        });
    }
}
