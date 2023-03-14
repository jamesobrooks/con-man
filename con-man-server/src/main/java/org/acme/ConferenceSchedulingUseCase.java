package org.acme;

import java.util.ArrayList;
import java.util.List;

public class ConferenceSchedulingUseCase {
  ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);

  public List<String> getConferences() {
    return gateway.getConferences();
  }

  public List<String> getSessionsByConference(String conference) {
    return gateway.getSessions(conference);
  }

  public boolean addConference(String conferenceName) {
    List<String> conferences = new ArrayList<>();
    try {
      List<String> result = gateway.addConference(conferenceName);
      conferences.addAll(result);
    } catch (Exception e) {
      return false;
    }
    return conferences.contains(conferenceName);
  }
}
