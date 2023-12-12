package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.TibiaEvent;
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

                TibiaEvent tibiaEvent = FilterChainQueue.addEventToMainQueue();
                if(tibiaEvent!=null)
                {
                    tibiaEventService.getTibiaEvent(tibiaEvent);
                }
            }
        }

    }

}
