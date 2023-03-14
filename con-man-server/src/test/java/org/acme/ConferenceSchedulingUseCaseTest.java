package org.acme;

import static com.google.common.truth.Truth.assertThat;
import static org.acme.TestConstants.MOCK_CONFERENCE_ONE;
import static org.acme.TestConstants.MOCK_CONFERENCE_TWO;
import static org.acme.TestConstants.MOCK_SESSION_ONE;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ConferenceSchedulingUseCaseTest {
  static ConferenceSchedulingUseCase conferenceSchedulingUseCase;

  @BeforeAll
  static void init() throws Exception {
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
    List<String> sessions =
        conferenceSchedulingUseCase.getSessionsByConference(MOCK_CONFERENCE_ONE);
    assertThat(sessions).contains(MOCK_SESSION_ONE);
  }

  @Test
  public void getSessionsByConferenceTestFakeConference() {
    List<String> sessions = conferenceSchedulingUseCase.getSessionsByConference("FakeCon");
    assertThat(sessions).isEmpty();
  }

  @Test
  public void addConferenceTest() {
    assertThat(conferenceSchedulingUseCase.addConference(MOCK_CONFERENCE_TWO)).isTrue();
  }
}
