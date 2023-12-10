package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.springframework.beans.factory.annotation.Autowired;

public class FilterChainQueueEater implements Runnable{


    /**
     * Thread responsible for processing messages and uploading them to the database
     */

    private TibiaEventService tibiaEventService;

    public FilterChainQueueEater(TibiaEventService tibiaEventService) {
        this.tibiaEventService = tibiaEventService;
    }

    @Override
    public void run() {

        while(true)
        {
            if(!FilterChainQueue.getQueue1().isEmpty())//jesli kolejka ma jakis element
            {
                if(FilterChainQueue.isQueueFlag1()) //jesli kolejka ma ustawiona flage na true
                {
                    FilterChainQueue.setQueueFlag1(false); //ustaw ja na false
                    tibiaEventService.getTibiaEvent(FilterChainQueue.getQueue1().poll());//dodaj do bazy danych element
                    FilterChainQueue.setQueueFlag1(true);//ustaw ja na true spowrotem
                }


            }


        }

    }

}
