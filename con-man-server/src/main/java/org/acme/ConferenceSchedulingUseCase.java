package org.acme;

import java.util.List;

public class ConferenceSchedulingUseCase {

    public List<String> getSessionsByConference(String conference) {
        ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);
        return gateway.getSessions(conference);
    }
}
