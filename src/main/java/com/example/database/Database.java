package com.example.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    // MySQL Connector 의 클래스. DB 연결 드라이버 정의
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // DB 경로
    private static final String URL = "database-2.cthnhpqt6mil.ap-northeast-2.rds.amazonaws.com:3306/test_data?useUnicode=true&autoReconnect=true&zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "cke5507k";

    @Test
    public void testConnection() throws Exception {
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}