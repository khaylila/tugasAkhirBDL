/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author milea
 */
public class DB {

    protected final String DB_URL = "jdbc:postgresql://103.16.116.143:5432/bengkel_mobil";
    protected final String USER = "bdl_c_kelompok3";
    protected final String PASS = "";
    protected String table;
    protected String pk;
    protected Connection conn;

    public DB(String[] config) {
        this.table = config[0];
        this.pk = config[1];
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPrepStatement(String query) throws SQLException {
        return this.conn.prepareStatement(query);
    }
    
//    public Statement getStatement(String Query) throws SQLException{
//        return this.conn.
//    }
}
