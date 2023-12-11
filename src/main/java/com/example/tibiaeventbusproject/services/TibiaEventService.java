package com.example.tibiaeventbusproject.services;

import org.springframework.stereotype.Service;

@Service
public class TibiaEventService {


    //tutaj bedziesz chcial uzyc repozytorum wiec bedzie musialo to byc beanem

    public void getTibiaEvent(String s)
    {
        System.out.println("Dopiero teraz obsluzylem element: "+s);
    }

}
