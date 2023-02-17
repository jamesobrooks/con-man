package org.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocalConferenceGateway implements ConferenceGateway {
    private Map<String, List<String>> conferences = new HashMap<>();

    @Override
    public List<String> addConference(String conference) {
        return conferences.put(conference, new ArrayList<>());
    }

    @Override
    public List<String> addSessionToConference(String conference, String session) {
        List<String> sessions = conferences.get(conference);
        sessions.add(session);
        return conferences.replace(conference, sessions);
    }

    @Override
    public List<String> getSessions(String conference) {
        return Optional.ofNullable(conferences.get(conference)).orElse(Collections.emptyList());
    }
}
