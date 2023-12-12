package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.TibiaEvent;

@FunctionalInterface
public interface FiltrMethod {
    void runSelectedEvent(TibiaEvent tibiaEvent);
}
