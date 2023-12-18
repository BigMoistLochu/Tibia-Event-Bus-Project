package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;
import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;


public class WebHookFilterChain implements FilterChain {

    private TibiaEventDto event;

    public WebHookFilterChain setEvent(TibiaEventDto event)
    {
        this.event = event;
        return this;
    }


    public void doFilter()
    {
        String state = event.getState();

        if(FilterChainMap.getMapOfChains().containsKey(state))
        {
            FilterChainMap.getMapOfChains().get(state).runSelectedEvent(event);
        }

    }
}
