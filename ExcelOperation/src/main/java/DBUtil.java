package main.java;

import java.sql.*;
import java.util.concurrent.Callable;

/**
 * oracle连接
 */
public class DBUtil {

    private Connection conn = null;

    private Statement stmt = null;

    private ResultSet rs = null;

    //url
    private final static String DB_URL = "";

    //连接驱动
    private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";

    //用户名
    private final static String DB_USERNAME = "";

    //密码
    private final static String DB_PASSWORD = "";

    //连接数据库
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //上传
    public boolean executeUpdate(String sql) {
        if (sql == null || sql.length() == 0)
            return false;
        try {
            this.getConnection();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void closeStmt() {

                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

    public void closeConnection() {
        try {
            if (conn != null) {
                //判断当前连接连接对象如果没有被关闭就调用关闭方法
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

