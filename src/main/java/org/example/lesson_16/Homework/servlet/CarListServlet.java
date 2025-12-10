package org.example.lesson_16.Homework.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson_16.Homework.dto.Car;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CarList",urlPatterns = {"/cars"}, initParams = {@WebInitParam(name = "imagesPath",value = "/images")})
public class CarListServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Car Servlet initialized");
        getServletContext().setAttribute("brand","BMW");
    }

    @Override
    public void destroy() {
        log("Car Servlet destroyed");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Car car = new Car("BMW", "5 series");
        resp.setStatus(200);
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        pw.println(car);

    }
}
