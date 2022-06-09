package com.olexyn.min.db;

import com.olexyn.min.db.model.PrettyResult;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class H2PocketServer {

    private Connection connection;
    Helpers helpers = new Helpers();

    protected H2PocketServer() {
        var jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:db1");
        jdbcDataSource.setUser("user");
        jdbcDataSource.setPassword("password");

        try {
            connection = ((DataSource) jdbcDataSource).getConnection();
        } catch (SQLException ignored) { /* ignore */ }
    }


    public Connection getConnection() {
        return connection;
    }

    protected abstract void init();


    public PrettyResult execute(String sql) throws SQLException {
        Statement stmt = getConnection().createStatement();
        boolean isResultSet = stmt.execute(sql);
        if (isResultSet) {
            ResultSet rs = stmt.getResultSet();
            String preyyt = helpers.getResult(rs);
            return new PrettyResult(preyyt, rs);
        } else {
            int result = stmt.getUpdateCount();
            return new PrettyResult("RAN UPDATE", null);
        }
    }

}
