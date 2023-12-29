# Opis Wątków w Klasie TibiaEventBusProjectApplication

W klasie TibiaEventBusProjectApplication tworzą się dwa wątki:

## WebHookThreadessinger
#### (trzymany tam jest token wiec nie ma go na githubie)
Odpowiedzialny za przyjmowanie wiadomości z Discorda.

## [FilterChainQueueEater](src/main/java/com/example/tibiaeventbusproject/discordWebHookLayer/filterChainProcess/FilterChainQueueEater.java)
Odpowiedzialny za przetwarzanie wiadomości z kolejki w klasie FilterChain.
