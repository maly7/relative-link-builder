package com.github.maly7.hateoas;

import com.github.maly7.sampleapp.TestApplication;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TestApplication.class})
public class RelativeLinkBuilderTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void linksShouldBeRelative() throws JSONException {
        String url = "/book/" + UUID.randomUUID().toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        JSONObject book = new JSONObject(response.getBody());
        String href = book.getJSONObject("_links").getJSONObject("self").getString("href");

        Assert.assertEquals("The self rel should be relative", url, href);
    }
}
