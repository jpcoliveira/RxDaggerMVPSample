package jafreela.com.br.rxdaggermvpsample;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import jafreela.com.br.rxdaggermvpsample.home.HomeActivity;
import jafreela.com.br.rxdaggermvpsample.networking.NetworkModule;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by joliveira on 20/12/17.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest extends InstrumentationTestCase {

    @Rule
    public ActivityTestRule<HomeActivity>
            mActivityRule = new ActivityTestRule<>(HomeActivity.class, false, true);

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        NetworkModule.BASEURL = server.url("/").toString();
    }


    @Test
    public void whenListisDisplayed_checkCountry() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(mockBuilder()));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        new HomeActivityRobot()
                .clickLastElement()
                .checkItem();
    }


    private String mockBuilder() {
        return "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"Yogyakarta\",\n" +
                "      \"description\": \"201 Hotel\",\n" +
                "      \"background\": \"http://www.tnetnoc.com/hotelphotos/591/327591/2631759-The-Cangkringan-Spa-Villas-Hotel-Yogyakarta-Guest-Room-3-RTS.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"Jakarta\",\n" +
                "      \"description\": \"71 Hotel\",\n" +
                "      \"background\": \"https://media-cdn.tripadvisor.com/media/photo-s/08/dc/c3/be/the-park-lane-jakarta.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"San Fransisco\",\n" +
                "      \"description\": \"309 Hotel\",\n" +
                "      \"background\": \"http://hotelunionsquare.com/sites/default/files/HUS-Home-2.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"New York\",\n" +
                "      \"description\": \"101 Hotel\",\n" +
                "      \"background\": \"https://a1.cdn-hotels.com/cos/production48/d1785/10fa68a0-ac68-11e4-99a1-d89d672bd508.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"name\": \"Bali\",\n" +
                "      \"description\": \"30 Hotel\",\n" +
                "      \"background\": \"http://balispecialevent.com/images/bali-hotel.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6\",\n" +
                "      \"name\": \"Paris\",\n" +
                "      \"description\": \"189 Hotel\",\n" +
                "      \"background\": \"http://www.hotel-r.net/im/hotel/bg/paris-hotel-21.jpg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"message\": \"Get city list.\",\n" +
                "  \"status\": 200\n" +
                "}";
    }
}
