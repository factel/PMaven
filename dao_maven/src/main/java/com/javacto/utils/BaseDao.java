package com.javacto.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * describe
 * 作者：曾昭武  adam8831
 */
public class BaseDao {

    private static String driverName;
    private static String url;
    private static String userName;
    private static String pwd;

    //类加载之前会执行的代码
    static {
         init();
    }

    //这个方法代码大家都不需要会写，也不用记，会复制就可以，因为以后不会这样写  现在是讲思路
    private static void init() {
        //这个方法只有一个目的，拿到db.properties 的信息 通过键获取值
        ///1.创建Properties
        Properties ps = new Properties();
        //2.拿到文件路径
        String path = "db.properties";
        //3.通过输出流读取db.properties 中的信息 数据
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(path);

        try {
            //4.把读到到的数据 加载到Properties
            ps.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5.通过键  获取值，值都在  Properties 对象中
        System.out.println(ps.get("db.driverName"));
        System.out.println(ps.getProperty("db.url"));

        //赋值  大家必需通过    System.out.println(ps.get("db.driverName")); 输出 有值了再赋值
        driverName=ps.getProperty("db.driverName");
        url=ps.getProperty("db.url");
        userName=ps.getProperty("db.userName");
        pwd=ps.getProperty("sbqSbqPwd");

    }

    public static Connection getCollections(){
        Connection conn = null;
        try {
            Class.forName(driverName);
            //2.建立连接  Connection
            conn= DriverManager.getConnection(url,userName,pwd);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  conn;
    }


    public static   void closeAll(Connection conn, Statement pstm, ResultSet rs){
        //7.释放资源
        try {

            if(null!=rs){
                rs.close();
            }
            if(null!=pstm){
                pstm.close();
            }
            if(null!=conn){
                conn.close();
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 封装DML
     */
    public static   int myExecuteUpdate(String sql, Object sbqSbq[]){
        int num = 0;
        Connection conn= BaseDao.getCollections();;
        PreparedStatement pstm =null;
        //这还不是最标准的写法，后面还有一次课
        try {
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值
            for(int i = 0;i<sbqSbq.length;i++){
                pstm.setObject(i+1,sbqSbq[i]);
            }
            num = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,null);
        }
        return num;
    }



    //希望所有同学，每次创建新的工程，如果使用BaseDao, 请务必这样测试
    public static void main(String[] args) {
        System.out.println(BaseDao.getCollections());
    }
}
