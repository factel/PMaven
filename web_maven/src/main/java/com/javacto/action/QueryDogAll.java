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
import java.util.List;

@WebServlet("/queryDogAll.do")
public class QueryDogAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //创建业务层代码
        DogService dogService = new DogServiceImpl();
        //调方法
        List<Dog> dogs = dogService.queryAll();
        //存req
        req.setAttribute("dogs",dogs);
        //跳转
        req.getRequestDispatcher("/dogList.jsp").forward(req,resp);




    }
}
