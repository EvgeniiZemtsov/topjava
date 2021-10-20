package ru.javawebinar.topjava.web;

import jdk.internal.logger.LoggerWrapper;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealsServlet extends HttpServlet {
    private static final LoggerWrapper log = LoggerWrapper.get(MealsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("getAll");
        req.setAttribute("mealList", UserMealsUtil.getFilteredWithExceeded(UserMealsUtil.MEAL_LIST, 2000));
        resp.getRequestDispatcher("mealList.jsp").forward(req, resp);
    }
}
