package org.example.lesson_17.Practice.CarController;
//package org.abb_tech.lesson5.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.abb_tech.lesson5.dto.CarDto;
//import org.abb_tech.lesson5.exception.CarNotFoundException;
//import org.abb_tech.lesson5.repository.CarRepositoryImpl;
//import org.abb_tech.lesson5.service.CarService;
//import org.abb_tech.lesson5.service.CarServiceImpl;
//import org.example.lesson_16.Practice.Exception.CarNotFoundException;
//import org.example.lesson_16.Practice.dto.CarDTO;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//public class CarController {


//    @WebServlet(name = "CarController", urlPatterns = "/cars")
//    public class CarController extends HttpServlet {
//
//        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//
//        private CarService carService;
//
//        @Override
//        public void init() throws ServletException {
//            carService = new CarServiceImpl(new CarRepositoryImpl());
//        }
//
//        @Override
//        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            String id = req.getParameter("id");
//            var params = req.getParameterMap();
//            try {
//                if (id != null) {
//                    CarDto car = carService.getCarById(Integer.parseInt(id));
//                    resp.getWriter().println(OBJECT_MAPPER.writeValueAsString(car));
//                } else {
//                    var cars = carService.getCars();
//                    resp.getWriter().println(OBJECT_MAPPER.writeValueAsString(cars));
//                }
//                resp.setStatus(200);
//                resp.setContentType("application/json");
//            } catch (Exception exception) {
//                if (exception instanceof Exception.CarNotFoundException) {
//                    resp.setStatus(404);
//                    resp.getWriter().println("Car not found");
//                } else {
//                    resp.setStatus(500);
//                    resp.getWriter().println("Internal Server Error");
//                }
//
//            }
//        }
//
//        @Override
//        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            StringBuffer sb = new StringBuffer();
//            try (BufferedReader bufferedReader = req.getReader()) {
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    sb.append(line);
//                }
//            }
//            CarDTO CarDto = OBJECT_MAPPER.readValue(sb.toString(), CarDto.class);
//            carService.addCar(CarDto);
//            resp.setStatus(201);
//        }
//    }
//
//}
