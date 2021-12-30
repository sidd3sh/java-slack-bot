package com.javabot.slack.controller;

import com.javabot.slack.client.SlackApiClient;
import com.javabot.slack.dto.SlackPostMessage;
import com.javabot.slack.dto.SlackPostMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
public class SlackMessageController {

    @Autowired
    private SlackApiClient slackApiClient;

    @PostMapping("/send")
    public ResponseEntity<SlackPostMessageResponse> postMessage(@RequestBody SlackPostMessage message) {
        return ResponseEntity.ok(slackApiClient.postMessage(message));
    }
}
