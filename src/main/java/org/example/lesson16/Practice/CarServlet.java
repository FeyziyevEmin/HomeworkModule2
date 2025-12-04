package org.example.lesson16.Practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CarServlet", urlPatterns = {"/cars", "/mashinlar"})
public class CarServlet extends HttpServlet {

    @Override
    public void init()throws ServletException {
        log("Car servlet initialized");
    }

    @Override
    public void destroy(){
        log("Car servlet Destroyed");
    }

    @Override
    protected void doGet(HttpServletRequest rog, HttpServletResponse resp) throws IOException {
        Car car = new Car("White",360);
        resp.setStatus(200);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(car);
    }
}
