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
            if(!FilterChainQueue.getQueue1().isEmpty())
            {

                String messageEvent = FilterChainQueue.addEventToMainQueue();
                if(messageEvent!=null)
                {
                    tibiaEventService.getTibiaEvent(messageEvent);
                }
            }
        }

    }

}
