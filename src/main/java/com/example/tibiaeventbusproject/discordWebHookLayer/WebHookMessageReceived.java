package com.example.tibiaeventbusproject.discordWebHookLayer;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class WebHookMessageReceived extends ListenerAdapter {

    private final FilterChain filterChain = new WebHookFilterChain();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        //tutaj bedzie sprawdzanie czy odpowiedni event jest zrobiony
            filterChain.setEvent(event).doFilter();
    }
}
