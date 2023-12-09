package com.example.tibiaeventbusproject.discordWebHookLayer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



public class WebHookFilterChain implements FilterChain{

    private MessageReceivedEvent event;

    public WebHookFilterChain setEvent(MessageReceivedEvent event)
    {
        this.event = event;
        return this;
    }

    public void doFilter()
    {
        String contexMessage = event.getMessage().getContentRaw();

        if(FilterChainMap.getFilterChains().containsKey(contexMessage))
        {
            FilterChainMap.getFilterChains().get(contexMessage).runSelectedEvent();
        }

    }
}
