package org.example.lesson_17.Practice.CarController;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson_17.Practice.Exception.CarNotFoundException;
import org.example.lesson_17.Practice.dto.CarDTO;
import org.example.lesson_17.Practice.repository.CarRepositoryImpl;
import org.example.lesson_17.Practice.service.CarService;
import org.example.lesson_17.Practice.service.CarServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "CarController", urlPatterns = "/cars")
public class CarController extends HttpServlet {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private CarService carService;

    @Override
    public void init() throws ServletException {
        carService = new CarServiceImpl(new CarRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        var params = req.getParameterMap();
        try {
            if (id != null) {
                CarDTO.CarDto car = carService.getCarById(Integer.parseInt(id));
                resp.getWriter().println(OBJECT_MAPPER.writeValueAsString(car));
            } else {
                var cars = carService.getCars();
                resp.getWriter().println(OBJECT_MAPPER.writeValueAsString(cars));
            }
            resp.setStatus(200);
            resp.setContentType("application/json");
        } catch (Exception exception) {
            if (exception instanceof CarNotFoundException) {
                resp.setStatus(404);
                resp.getWriter().println("Car not found");
            } else {
                resp.setStatus(500);
                resp.getWriter().println("Internal Server Error");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader bufferedReader = req.getReader()) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        }
        CarDTO.CarDto CarDto = OBJECT_MAPPER.readValue(sb.toString(), CarDTO.CarDto.class);
        carService.addCar(CarDto);
        resp.setStatus(201);
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        var params = req.getParameterMap();
        try {
            if (id == null) {
                resp.setStatus(400);
                resp.getWriter().println("Invalid ID");
                return;
            }

            StringBuffer sb = new StringBuffer();
            try (BufferedReader bufferedReader = req.getReader()) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            }

            CarDTO.CarDto updatedCar = OBJECT_MAPPER.readValue(sb.toString(), CarDTO.CarDto.class);

            carService.updateCar(Integer.parseInt(id), updatedCar);

            resp.setStatus(200);
            resp.getWriter().println("Car Updated successfully");

        } catch (Exception exception) {
            if (exception instanceof CarNotFoundException) {
                resp.setStatus(404);
                System.out.println("Car not found");
            } else {
                resp.setStatus(500);
                System.out.println("Internal Server Error");
            }
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            if (id == null) {
                resp.setStatus(400);
                resp.getWriter().println("Invalid ID");
                return;
            }

            carService.deleteCarById(Integer.parseInt(id));
            resp.setStatus(204);

        } catch (Exception exception) {
            if (exception instanceof CarNotFoundException) {
                resp.setStatus(404);
            } else {
                resp.setStatus(500);
                System.out.println("Internal Server Error");
            }
        }


    }
}
