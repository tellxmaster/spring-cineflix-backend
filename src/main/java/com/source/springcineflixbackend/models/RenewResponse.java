package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RenewResponse {
    @JsonProperty("timeStamp")
    protected LocalDateTime timeStamp;
    @JsonProperty("ok")
    protected boolean ok;
    @JsonProperty("token")
    protected String token;
    @JsonProperty("msg")
    protected String msg;

    public RenewResponse(LocalDateTime timeStamp, boolean ok, String token, String msg) {
        this.timeStamp = timeStamp;
        this.ok = ok;
        this.token = token;
        this.msg = msg;
    }
}
