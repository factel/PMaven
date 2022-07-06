package com.javacto.action;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateDog.do")
public class UpdateDog extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //处理响映编码格式
        resp.setContentType("text/html;charset=UTF-8");

        //1.获取请求参数
        String strId = req.getParameter("id");
        Integer id = Integer.parseInt(strId);
        String strSal = req.getParameter("sal");
        Double sal = Double.parseDouble(strSal);
        String breed = req.getParameter("breed");

        //2.把前端获取 的结果存入对象中
        Dog dog = new Dog();
        dog.setId(id);
        dog.setSal(sal);
        dog.setBreed(breed);

        //2.创建业务层代码
        DogService dogService = new DogServiceImpl();
        dogService.updateDog(dog);

        //4.跳转到jsp
        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);
    }
}
