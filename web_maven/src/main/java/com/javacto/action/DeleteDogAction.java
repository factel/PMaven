package com.javacto.action;

import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteDog")
public class DeleteDogAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String strId=req.getParameter("id");
        Integer id = Integer.parseInt(strId);// 转为int类型
        DogService dogService = new DogServiceImpl();

        dogService.deleteDog(id);


        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);

    }
}
