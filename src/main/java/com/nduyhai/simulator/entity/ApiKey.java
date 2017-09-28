package com.nduyhai.simulator.entity;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class ApiKey implements Serializable {

    @Enumerated(EnumType.STRING)
    private RequestMethod method;

    private String url;

    public ApiKey() {
    }

    public ApiKey(RequestMethod method, String url) {
        this.method = method;
        this.url = url;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiKey apiKey = (ApiKey) o;

        if (method != apiKey.method) return false;
        return url.equals(apiKey.url);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
