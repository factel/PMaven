package com.javacto.service;

import com.javacto.po.Dog;

import java.util.List;

/**
 * describe 业务层接口
 */
public interface DogService {
    /**
     * 登陆
     * @param breed
     * @param id
     * @return
     */
    public Dog login(String breed, int id);

    /**
     * 添加
     */
    public int addDog(Dog dog);

    /**
     * 删除
     */
    public int deleteDog(int id);

    /**
     * 根据ID查询
     */
    public Dog findDogByID(int id);


    /**
     * 修改
     */
    public int updateDog(Dog dog);

    /**
     * 查询所有
     */
    public List<Dog> queryAll();
}
