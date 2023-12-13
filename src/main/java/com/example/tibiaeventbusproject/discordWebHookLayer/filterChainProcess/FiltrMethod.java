package com.example.tibiaeventbusproject.discordWebHookLayer.filterChainProcess;

import com.example.tibiaeventbusproject.models.tibiaEventResources.TibiaEventDto;

@FunctionalInterface
public interface FiltrMethod {
    void runSelectedEvent(TibiaEventDto tibiaEventDto);
}
