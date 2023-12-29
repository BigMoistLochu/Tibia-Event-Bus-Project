```java
    private final FilterChain filterChain = new WebHookFilterChain();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event != null) {
            String message = event.getMessage().getContentRaw();

            TibiaEventDto parsedEvent = TibiaEventJsonHandler.getParsedTibiaEvent(message);

            if (parsedEvent != null) {
                filterChain.setEvent(parsedEvent).doFilter();
            }
        }
    }
}

