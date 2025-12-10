package org.example.lesson_16.Homework.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("AppListener: App started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AppListener: App stopped");
    }
}
