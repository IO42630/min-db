package com.olexyn.min.db.model;

import java.sql.ResultSet;

public class PrettyResult {

    private final String pretty;
    private final ResultSet resultSet;

    public PrettyResult(String pretty, ResultSet resultSet) {
        this.pretty = pretty;
        this.resultSet = resultSet;
    }

    public String getPretty() {
        return pretty;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

}
