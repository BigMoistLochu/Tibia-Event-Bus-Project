package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.TibiaEvent;

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

    private final static Queue<TibiaEvent> queue1 = new LinkedList<>();
    private final static Queue<TibiaEvent> queueMain = new LinkedList<>();




    protected void addEventToFirstQueue(TibiaEvent tibiaEvent)
    {
        queue1.offer(tibiaEvent);
    }

    /**
     * Wszystko ponizej jest tylko dla watku FilterChainQueueEater
     * ------------------------------------------------------------------------------------
     */
    protected synchronized static TibiaEvent addEventToMainQueue()
    {

        if(!queue1.isEmpty())
        {
            TibiaEvent element = queue1.poll();
            if(element!=null)
            {
                queueMain.offer(element);
            }

            TibiaEvent elementMain = queueMain.poll();

            if(elementMain!=null)
            {
                return elementMain;
            }
        }

        return null;
    }


    protected static Queue<TibiaEvent> getQueue1()
    {
        return queue1;
    }










}
