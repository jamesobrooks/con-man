package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/conferences")
public class ConferenceSchedulingController {
    ConferenceSchedulingUseCase conferenceSchedulingUseCase = new ConferenceSchedulingUseCase();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getConferences() {
        return conferenceSchedulingUseCase.getConferences();
    }
}
