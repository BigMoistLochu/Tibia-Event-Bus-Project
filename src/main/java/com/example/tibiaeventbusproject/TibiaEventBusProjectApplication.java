package com.example.tibiaeventbusproject;

import com.example.tibiaeventbusproject.discordWebHookLayer.WebHookThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TibiaEventBusProjectApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(TibiaEventBusProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //start Project
        WebHookThread webHookThread = new WebHookThread();
        webHookThread.run();
    }
}
