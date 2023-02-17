package org.acme;

import java.util.List;

public class ConferenceSchedulingUseCase {
    ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);
    public List<String> getConferences() {
        return gateway.getConferences();
    }

    public List<String> getSessionsByConference(String conference) {
        return gateway.getSessions(conference);
    }
}
