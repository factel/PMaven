package com.javacto.service;

import com.javacto.dao.DogDao;
import com.javacto.dao.DogDaoImpl;
import com.javacto.po.Dog;

import java.util.List;

/**
 * describe  业务实现类
 */
public class DogServiceImpl implements DogService {
    private DogDao dogDao = new DogDaoImpl();

    /**
     * 登陆
     */
    @Override
    public Dog login(String breed, int id) {
        return dogDao.login(breed, id);
    }

    /**
     * 增加
     */
    @Override
    public int addDog(Dog dog) {
        return dogDao.addDog(dog);
    }

    /**
     * 删除
     */
    @Override
    public int deleteDog(int id) {
        return dogDao.deleteDog(id);
    }

    @Override
    public int updateDog(Dog dog) {
        return dogDao.updateDog(dog);
    }

    @Override
    public Dog findDogByID(int id) {
        return dogDao.findDogByID(id);
    }


    public List<Dog> queryAll() {
        return dogDao.queryAll();
    }
}
