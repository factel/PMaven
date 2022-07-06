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
import java.io.PrintWriter;

@WebServlet("/checkId.do")
public class CheckId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String strId = req.getParameter("id");
        Integer id = Integer.parseInt(strId);
        String location = req.getParameter("location");

        //创建业务层对象
        DogService dogService = new DogServiceImpl();

        //通过用户名查询  返回User对象 或boolean
        Dog dogByID = dogService.findDogByID(id);
        if (dogByID != null) {
            out.print("0");
        } else {
            out.print("1");
        }

    }
}

