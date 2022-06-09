package com.olexyn.min.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        Helpers helpers = new Helpers();

        Connection conn = null;

        System.out.println(conn);

        Statement stmt = conn.createStatement();

        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        rs = stmt.executeQuery("SELECT * FROM orders");
        helpers.printResult(rs);

        int result;

        result = stmt.executeUpdate("insert into customers values(10, 'Maya')");

        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        result = stmt.executeUpdate("update customers set name = 'Bob' where name = 'Paul'");

        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        result = stmt.executeUpdate("delete from customers where name = 'Peter'");


        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        while (true){
            Thread.sleep(500);
        }
    }


}

