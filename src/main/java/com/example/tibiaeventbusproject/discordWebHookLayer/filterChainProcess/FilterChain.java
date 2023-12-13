package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;

public interface FilterChain {

    /**
     * Method set the message(Event From Discord) to variable in WebHookFilterChainClass
     * @param event
     * @return
     */
    WebHookFilterChain setEvent(TibiaEventDto event);

    /**
     * Method that filters all messages and selects the correct one
     */
    void doFilter();
}
