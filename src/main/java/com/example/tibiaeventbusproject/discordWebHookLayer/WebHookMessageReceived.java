package com.example.tibiaeventbusproject.discordWebHookLayer;

import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.FilterChain;
import com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess.WebHookFilterChain;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * If you want start project you need add this class to the addEventListeners in JDA
 */

public class WebHookMessageReceived extends ListenerAdapter {

    private final FilterChain filterChain = new WebHookFilterChain();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        //tutaj bedzie sprawdzanie czy odpowiedni event jest zrobiony
        //sprawdzamy czy nie jest nullem tez!
        //wyciagamy otcbot.message()
        if(event!=null)
        {
            filterChain.setEvent(event).doFilter();
        }

    }
}
