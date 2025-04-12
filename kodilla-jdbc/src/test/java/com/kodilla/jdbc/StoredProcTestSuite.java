package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {   // Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate("UPDATE BOOKS SET BESTSELLER = 0");

        // When
        statement.execute("CALL UpdateBestsellers()");

        // Then
        String checkSql = """
        SELECT COUNT(*) AS CNT
        FROM BOOKS
        WHERE BESTSELLER = 1
    """;
        ResultSet rs = statement.executeQuery(checkSql);

        int count = -1;
        if (rs.next()) {
            count = rs.getInt("CNT");
        }
        System.out.println("🧾 Bestsellerów po procedurze: " + count);

        assertTrue(count >= 0);

        rs.close();
        statement.close();
    }


}