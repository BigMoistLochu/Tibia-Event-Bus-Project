package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventMapper;
import com.example.tibiaeventbusproject.services.TibiaEventService;

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

                TibiaEventDto tibiaEventDto = FilterChainQueue.addEventToMainQueue();
                if(tibiaEventDto !=null)
                {

                    //tutaj bedzie sprawdzac czy taki uzytkownik istnieje ;)

                    TibiaEvent tibiaEvent = TibiaEventMapper.convertDtoToEntity(tibiaEventDto);
                    tibiaEventService.getTibiaEvent(tibiaEvent);
                }
            }
        }

    }

}
