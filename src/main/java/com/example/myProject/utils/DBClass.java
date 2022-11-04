package com.example.myProject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBClass {
    //public enum TABLES {CELLS, LEVELS, CELLS_LEVELS, USERS};

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    private DBClass() {}

    public static synchronized JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }
}
