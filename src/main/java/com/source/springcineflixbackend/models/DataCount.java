package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)

public class DataCount {
    protected String label;
    protected int count;
    protected int total;

    public DataCount() {
    }

    public DataCount(String label, int count, int total) {
        this.label = label;
        this.count = count;
        this.total = total;
    }
}
