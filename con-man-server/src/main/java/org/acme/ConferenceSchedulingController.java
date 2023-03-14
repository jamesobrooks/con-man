package org.acme;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/conferences")
public class ConferenceSchedulingController {
  ConferenceSchedulingUseCase conferenceSchedulingUseCase = new ConferenceSchedulingUseCase();

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public List<String> getConferences() {
    return conferenceSchedulingUseCase.getConferences();
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public boolean addConference(String conferenceName) {
    return conferenceSchedulingUseCase.addConference(conferenceName);
  }
}
