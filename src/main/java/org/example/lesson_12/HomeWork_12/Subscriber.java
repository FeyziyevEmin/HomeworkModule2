package org.example.lesson_12.HomeWork_12;

public class Subscriber implements Runnable {
    private final String name;
    private final NewsPublisher publisher;

    public Subscriber(String name, NewsPublisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public void update(String news) {
        System.out.println(name + " xəbər aldı: " + news);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String news = publisher.getLatestNews();
                update(news); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " dayandırıldı");
        }
    }
}
