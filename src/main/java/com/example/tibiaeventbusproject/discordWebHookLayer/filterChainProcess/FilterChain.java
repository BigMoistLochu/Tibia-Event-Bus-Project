package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.TibiaEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface FilterChain {

    /**
     * Method set the message(Event From Discord) to variable in WebHookFilterChainClass
     * @param event
     * @return
     */
    WebHookFilterChain setEvent(TibiaEvent event);

    /**
     * Method that filters all messages and selects the correct one
     */
    void doFilter();
}
