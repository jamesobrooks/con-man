package org.acme;

import java.util.List;

public interface ConferenceGateway {
  public List<String> addConference(String conference) throws Exception;

  public List<String> getConferences();

  public List<String> addSessionToConference(String conference, String session);

  public List<String> getSessions(String conference);
}
