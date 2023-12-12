package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;
import com.example.tibiaeventbusproject.models.TibiaEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



public class WebHookFilterChain implements FilterChain {

    private TibiaEvent event;

    public WebHookFilterChain setEvent(TibiaEvent event)
    {
        this.event = event;
        return this;
    }



    public void doFilter()
    {
        String state = event.getState();

        if(FilterChainMap.getMapOfChains().containsKey(state))
        {
            FilterChainMap.getMapOfChains().get(state).runSelectedEvent();
        }

    }
}
