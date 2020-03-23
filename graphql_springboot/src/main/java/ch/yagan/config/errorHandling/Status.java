package ch.yagan.config;

import org.springframework.http.HttpStatus;

public class Status {

    private HttpStatus status;

    public Status(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return status.value();
    }

    public String getReasonPhrase() {
        return status.getReasonPhrase();
    }
}
