package org.acme;

import static org.acme.ObjectFactory.registerObject;

public class RuntimeObjectFactory {
    public static void init() {
        // TODO: Replace LocalConferenceGateway with H2ConferenceGateway (or something)
        registerObject(ConferenceGateway.class, new LocalConferenceGateway());
    }
}
