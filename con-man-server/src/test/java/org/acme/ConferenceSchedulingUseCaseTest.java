package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@QuarkusTest
public class ConferenceSchedulingUseCaseTest {
    static ConferenceSchedulingUseCase conferenceSchedulingUseCase;
    static final String MOCK_CONFERENCE_ONE = "BalloonCon2023";
    static final String MOCK_SESSION_ONE = "Birds of South America";

    @BeforeAll
    static void init() {
        conferenceSchedulingUseCase = new ConferenceSchedulingUseCase();
        TestObjectFactory.init();
        ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);
        gateway.addConference(MOCK_CONFERENCE_ONE);
        gateway.addSessionToConference(MOCK_CONFERENCE_ONE, MOCK_SESSION_ONE);
    }

    @Test
    public void getSessionsByConferenceTest() {
        List<String> sessions = conferenceSchedulingUseCase.getSessionsByConference(MOCK_CONFERENCE_ONE);
        assertThat(sessions).contains(MOCK_SESSION_ONE);
    }

    @Test
    public void getSessionsByConferenceTestFakeConference() {
        List<String> sessions = conferenceSchedulingUseCase.getSessionsByConference("FakeCon");
        assertThat(sessions).isEmpty();
    }
}
