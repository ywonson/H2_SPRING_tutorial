package dev.yongwon.h2board;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
public class H2BoardApplicationTests {
    public static void main(String[] a)
            throws Exception {
        Connection conn = DriverManager.
            getConnection("jdbc:h2:~/test", "sa", "");
        // add application code here
        System.out.println("this is conn: " + conn);
        conn.close();
    }
}