package org.acme;

public class TestObjectFactory extends ObjectFactory {
    public static void init() {
        registerObject(ConferenceGateway.class, new LocalConferenceGateway());
    }
}
