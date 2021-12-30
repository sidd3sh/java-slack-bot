package com.javabot.slack.dto;

public class SlackPostMessageResponse {

    private String response;

    public SlackPostMessageResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
