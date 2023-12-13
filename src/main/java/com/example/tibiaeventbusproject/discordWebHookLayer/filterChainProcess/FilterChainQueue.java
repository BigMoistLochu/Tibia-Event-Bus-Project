package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;

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

    private final static Queue<TibiaEventDto> queue1 = new LinkedList<>();
    private final static Queue<TibiaEventDto> queueMain = new LinkedList<>();




    protected void addEventToFirstQueue(TibiaEventDto tibiaEventDto)
    {
        queue1.offer(tibiaEventDto);
    }

    /**
     * Wszystko ponizej jest tylko dla watku FilterChainQueueEater
     * ------------------------------------------------------------------------------------
     */
    protected synchronized static TibiaEventDto addEventToMainQueue()
    {

        if(!queue1.isEmpty())
        {
            TibiaEventDto element = queue1.poll();
            if(element!=null)
            {
                queueMain.offer(element);
            }

            TibiaEventDto elementMain = queueMain.poll();

            if(elementMain!=null)
            {
                return elementMain;
            }
        }

        return null;
    }


    protected static Queue<TibiaEventDto> getQueue1()
    {
        return queue1;
    }










}
