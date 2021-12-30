package com.javabot.slack.client;

import com.javabot.slack.dto.SlackPostMessage;
import com.javabot.slack.dto.SlackPostMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SlackApiClient {

    private final RestTemplate restTemplate;

    @Value("${slack.api.chat}")
    private String slackChatApiEndpoint;

    @Autowired
    public SlackApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public SlackPostMessageResponse postMessage(final SlackPostMessage message) {

        final HttpEntity<SlackPostMessage> request = new HttpEntity<>(message);
        final String rawJsonResponse = this.restTemplate.postForObject(slackChatApiEndpoint, request, String.class);
        return new SlackPostMessageResponse(rawJsonResponse);
    }
}
