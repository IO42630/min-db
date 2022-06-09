package com.olexyn.min.db;

import java.sql.SQLException;
import java.sql.Statement;

public class H2PocketServerImpl extends H2PocketServer {

    public H2PocketServerImpl() {
        super();
        init();
    }

    protected void init() {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate("CREATE TABLE CUSTOMERS (" + "CUSTOMER_ID INTEGER PRIMARY KEY, NAME" + " VARCHAR(255))");
            stmt.executeUpdate("CREATE TABLE ORDERS (ORDERS_ID" + " INTEGER PRIMARY KEY, ITEM" + " VARCHAR(255), " + "CUSTOMER_ID INTEGER )");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (1, 'Peter')");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (2, 'Paul')");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (3, 'Alice')");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (1, 'Cake', 1)");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (2, 'Coffee', 3)");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (3, 'Tea', 4)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
