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

@WebServlet("/addOneDog.do")
public class AddDogAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //处理响映编码格式
        resp.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        String strId = req.getParameter("id");
        Integer id = Integer.parseInt(strId);
        String strSal = req.getParameter("sal");
        Double sal = Double.parseDouble(strSal);
        String breed = req.getParameter("breed");

        //将前端结果存入Dog对象中
        Dog dog = new Dog();
        dog.setId(id);
        dog.setSal(sal);
        dog.setBreed(breed);

        //调取业务层代码
        DogService dogService = new DogServiceImpl();
        dogService.addDog(dog);

        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);


    }
}
