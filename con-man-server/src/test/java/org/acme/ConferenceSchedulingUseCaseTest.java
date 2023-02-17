package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.acme.TestConstants.MOCK_CONFERENCE_ONE;
import static org.acme.TestConstants.MOCK_SESSION_ONE;

@QuarkusTest
public class ConferenceSchedulingUseCaseTest {
    static ConferenceSchedulingUseCase conferenceSchedulingUseCase;

    @BeforeAll
    static void init() {
        TestObjectFactory.init();
        conferenceSchedulingUseCase = new ConferenceSchedulingUseCase();
        ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);
        gateway.addConference(MOCK_CONFERENCE_ONE);
        gateway.addSessionToConference(MOCK_CONFERENCE_ONE, MOCK_SESSION_ONE);
    }

    @Test
    public void getConferencesTest() {
        List<String> conferences = conferenceSchedulingUseCase.getConferences();
        assertThat(conferences).contains(MOCK_CONFERENCE_ONE);
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
