package org.example.lesson_17.Practice.config;

import com.zaxxer.hikari.HikariConfig;

import javax.sql.DataSource;

public class DBConfig {
    private static DataSource dataSource;

    static{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/car");
    }
}
