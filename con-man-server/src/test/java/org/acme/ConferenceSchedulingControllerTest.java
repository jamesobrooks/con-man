package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.acme.TestConstants.MOCK_CONFERENCE_ONE;
import static org.acme.TestConstants.MOCK_SESSION_ONE;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ConferenceSchedulingControllerTest {

    @BeforeAll
    static void init() throws Exception {
        TestObjectFactory.init();
        ConferenceGateway gateway = ObjectFactory.getObjectByAbstractClass(ConferenceGateway.class);
        gateway.addConference(MOCK_CONFERENCE_ONE);
        gateway.addSessionToConference(MOCK_CONFERENCE_ONE, MOCK_SESSION_ONE);
    }

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/conferences")
          .then()
             .statusCode(200)
             .body(is("[BalloonCon2023]"));
    }

}