package org.example.lesson_16.Homework.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson_16.Homework.dto.Car;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/car"})
public class CarDetailsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("CarDetailServlet initialized");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("CarDetailsServlet destroyed");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String brand = (String) getServletContext().getAttribute("brand");
        Car car = new Car(brand,"M3");
        resp.setStatus(200);
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        pw.println(car);
    }
}
