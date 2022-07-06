package com.javacto.dao;

import com.javacto.po.Dog;
import com.javacto.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DogDaoImpl implements DogDao {
    /**
     * 登陆
     */
    public Dog login(String breed, int id) {
        Connection conn = BaseDao.getCollections();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Dog dog = null;
        try {
            //3.处理预编译 SQL语句  
            String sql = "SELECT * FROM dog WHERE breed =? AND id=? ";
            pstm = conn.prepareStatement(sql);
            //4.赋值
            pstm.setObject(1, breed);
            pstm.setObject(2, id);
            //5.运行执行预编译 SQL语句 
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()) {
                //创建对象
                dog = new Dog();
                dog.setId(rs.getInt(1));
                dog.setSal(rs.getDouble(2));
                dog.setBreed(rs.getString(3));
                //如果进来了，就知道这里有数据,
                System.out.println(rs.getInt(1) + "品种为:" + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeAll(conn, pstm, rs);
        }
        return dog;
    }


    /**
     * 添加
     */
    public int addDog(Dog dog) {
        String sql = "INSERT INTO dog(id,sal,breed) VALUES(?,?,?)";
        Object sbqSbq[] = {dog.getId(), dog.getSal(), dog.getBreed()};
        return BaseDao.myExecuteUpdate(sql, sbqSbq);
    }

    /**
     * 删除
     */
    public int deleteDog(int id) {
        String sql = "DELETE FROM Dog WHERE id=?";
        Object sbqSbq[] = {id};
        return BaseDao.myExecuteUpdate(sql, sbqSbq);
    }

    /**
     * 修改
     */
    public int updateDog(Dog dog) {
        String sql = "UPDATE Dog SET breed=?,sal=? WHERE id=?";
        Object sbqSbq[] = { dog.getBreed(), dog.getSal(),dog.getId()};
        return BaseDao.myExecuteUpdate(sql, sbqSbq);
    }

    /**
     * 查询所有
     */
    public List<Dog> queryAll() {
        // 0必需创建集合对象
        List<Dog> list = new ArrayList<Dog>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getCollections();
            //3.处理预编译 SQL语句
            String sql = "SELECT * FROM dog  ";
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值
            //5.运行执行预编译 SQL语句 pstm.executeQuery(注意这里不能有SQL语句)
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()) {
                //这里面必需有3个步骤
                //1.必需在循环这里面创建对象
                Dog dog1 = new Dog();
                //2.把值添加到dog对象中
                dog1.setId(rs.getInt("id"));
                dog1.setSal(rs.getDouble(2));
                dog1.setBreed(rs.getString(3));
                //3.把dog1 add到集合中
                list.add(dog1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeAll(conn, pstm, rs);
        }
        return list;
    }

    /**
     * 根据ID查询
     */
    public Dog findDogByID(int id) {
        Connection conn = BaseDao.getCollections();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //我这里只会定义，不会创建
        Dog dog = null;
        try {
            //3.处理预编译 SQL语句
            String sql = "SELECT * FROM dog WHERE id=?  ";
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值
            pstm.setObject(1, id);
            //5.运行执行预编译 SQL语句
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()) {
                //创建对象
                dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setSal(rs.getDouble(2));
                dog.setBreed(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeAll(conn, pstm, rs);
        }
        return dog;
    }
}