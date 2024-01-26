package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.loginAndRegisterLayer.HashGenerator;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEvent;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventMapper;
import com.example.tibiaeventbusproject.services.TibiaEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterChainQueueEater implements Runnable{


    /**
     * Thread responsible for processing messages and uploading them to the database
     */

    private TibiaEventService tibiaEventService;

    private static Logger logger = LoggerFactory.getLogger(FilterChainQueueEater.class);

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

                if(tibiaEventDto != null)
                {

                    //tutaj bedzie sprawdzac czy taki uzytkownik istnieje ;)

                    TibiaEvent tibiaEvent = TibiaEventMapper.convertDtoToEntity(tibiaEventDto);
                    tibiaEventService.getTibiaEvent(tibiaEvent);
                    logger.info("Event Zostal Dodany Do bazy");
                }
            }
        }

    }

}
