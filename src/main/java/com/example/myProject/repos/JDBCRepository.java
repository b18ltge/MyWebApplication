package com.example.myProject.repos;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public abstract class JDBCRepository<T> {
    protected final JdbcTemplate jdbcTemplate;

    protected JDBCRepository() {
        jdbcTemplate = jdbcTemplate(dataSource());
    }

    @Bean("dataSource")
    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(" jdbc:postgresql://localhost:5432/MyGameDataBase");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Agent023");

        return dataSource;
    }

    @Bean("jdbcTemplate")
    private JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    abstract int insert(T object);

    abstract int update(T object);

    abstract T findById(Integer id);

    abstract int deleteById(Integer id);

    abstract List<T> findAll();

    abstract int deleteAll();
}
