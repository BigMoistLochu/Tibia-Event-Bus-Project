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

    private final static Queue<String> queue1 = new LinkedList<>();
    private final static Queue<String> queueMain = new LinkedList<>();




    protected void addEventToFirstQueue(String message)
    {
        queue1.offer(message);
    }

    /**
     * Wszystko ponizej jest tylko dla watku FilterChainQueueEater
     * ------------------------------------------------------------------------------------
     */
    protected synchronized static String addEventToMainQueue()
    {

        if(!queue1.isEmpty())
        {
            String element = queue1.poll();
            if(element!=null)
            {
                queueMain.offer(element);
            }

            String elementMain = queueMain.poll();

            if(elementMain!=null)
            {
                return elementMain;
            }
        }

        return null;
    }


    protected static Queue<String> getQueue1()
    {
        return queue1;
    }










}
