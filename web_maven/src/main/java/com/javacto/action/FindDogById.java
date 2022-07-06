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
@WebServlet("/findDogById.do")
public class FindDogById extends HttpServlet {

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
        String strId= req.getParameter("id");
        Integer id = Integer.parseInt(strId);

        //2.创建业务层代码
        DogService dogService = new DogServiceImpl();
        Dog dog = dogService.findDogByID(id);
        //存值
        req.setAttribute("dog",dog);
        req.setAttribute("msg","2");

        //4.跳转到jsp
        req.getRequestDispatcher("/addOrUpdateDog.jsp").forward(req,resp);
    }
}