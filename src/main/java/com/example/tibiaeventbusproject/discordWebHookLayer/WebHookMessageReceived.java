package com.example.tibiaeventbusproject.discordWebHookLayer;

import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChain;
import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.WebHookFilterChain;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * If you want start project you need add this class to the addEventListeners in JDA
 */

public class WebHookMessageReceived extends ListenerAdapter {

    private final FilterChain filterChain = new WebHookFilterChain();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event!=null)
        {
            String message = event.getMessage().getContentRaw();
            TibiaEventDto parsedEvent = TibiaEventJsonHandler.getParsedTibiaEvent(message);
            if(parsedEvent!=null)
            {
                filterChain.setEvent(parsedEvent).doFilter();
            }

        }



    }
}
