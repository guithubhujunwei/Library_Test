package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Utils {
    // 1. 创建连接池
   private static ComboPooledDataSource pool = new ComboPooledDataSource();


    // 2. 提供静态方法获取连接
    public static Connection getConnection(){
        try {




            return pool.getConnection();
        }catch (Exception e) {
            System.out.println(e.toString());
        }


        return  null;
    }

    // 3. 提供 获取连接池的方法
    public static DataSource  getDS(){
        return  pool;
    }
 }
