package com.example.tibiaeventbusproject.discordWebHookLayer;
import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChain;
import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChainMap;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



public class WebHookFilterChain implements FilterChain {

    private MessageReceivedEvent event;

    public WebHookFilterChain setEvent(MessageReceivedEvent event)
    {
        this.event = event;
        return this;
    }

    public void doFilter()
    {

        String contexMessage = event.getMessage().getContentRaw();

        if(FilterChainMap.getMapOfChains().containsKey(contexMessage))
        {
            FilterChainMap.getMapOfChains().get(contexMessage).runSelectedEvent();
        }

    }
}
