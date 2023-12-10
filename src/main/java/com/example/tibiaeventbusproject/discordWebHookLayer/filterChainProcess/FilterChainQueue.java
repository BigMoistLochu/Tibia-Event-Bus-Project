package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import java.util.LinkedList;
import java.util.Queue;


public final class FilterChainQueue {

    private static FilterChainQueue INSTANCE;
    private FilterChainQueue(){}

    public static FilterChainQueue getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new FilterChainQueue();
        }

        return INSTANCE;
    }

    private static Queue<String> queue1 = new LinkedList<>();
    private static Queue<String> queue2 = new LinkedList<>();



    private static boolean QUEUE_FLAG1 = true; //na starcie zmienna beda ustawione na true
    private static boolean QUEUE_FLAG2 = true;



    protected void addEventToQueue(String message)
    {
        if(QUEUE_FLAG1==true)
        {
            if(queue1.offer(message))
            {
                System.out.println("ELEMENT ZOSTAL DODANY DO KOLEJKI: "+ message);
            }
        }
        else if(QUEUE_FLAG2 == true) {

            if(queue2.offer(message))
            {
                System.out.println("Element zostal dodany: "+ message);
            }
        }
    }






    /**
     * Wszystko ponizej jest tylko dla watku FilterChainQueueEater
     * ------------------------------------------------------------------------------------
     */
    protected static boolean isQueueFlag1() {
        return QUEUE_FLAG1;
    }

    protected static void setQueueFlag1(boolean queueFlag1) {
        QUEUE_FLAG1 = queueFlag1;
    }

    protected static boolean isQueueFlag2() {
        return QUEUE_FLAG2;
    }

    protected static void setQueueFlag2(boolean queueFlag2) {
        QUEUE_FLAG2 = queueFlag2;
    }

    protected static Queue<String> getQueue1() {
        return queue1;
    }

    protected static Queue<String> getQueue2() {
        return queue2;
    }
}
