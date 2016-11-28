package me.kapehh.DigestJobTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.PrintWriter;
import java.io.StringWriter;

@ComponentScan
@EnableAutoConfiguration
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
