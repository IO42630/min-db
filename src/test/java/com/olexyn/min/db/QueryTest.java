package com.olexyn.min.db;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class QueryTest {

    private static final String expectedResult1 =
        " | CUSTOMER_ID | NAME  | \n" +
        " | 1           | Peter | \n" +
        " | 2           | Paul  | \n" +
        " | 3           | Alice | \n";

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        var result = new H2PocketServerImpl().execute("SELECT * FROM customers").getPretty();
        Assert.assertEquals(result, expectedResult1);
        int br = 0;
    }
}
