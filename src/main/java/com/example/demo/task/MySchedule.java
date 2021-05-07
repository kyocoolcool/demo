package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/5/5 9:29 AM
 */
@Component
public class MySchedule {
    @Scheduled(cron = "*/5 * * * * ?")
    public void hello() {
        System.out.println("hello");
    }


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./no/hello.txt");
        if (!path.getParent().toFile().exists()) {
            Files.createDirectories(path.getParent());
        }
        Files.write(path, "BBB".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }
}
