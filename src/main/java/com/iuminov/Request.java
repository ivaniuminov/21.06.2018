package com.iuminov;

import java.util.Objects;

public final class Request {

    private final String method;
    private final String url;

    public Request(final String method, final String url) {
        this.method = method;
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(method, request.method) &&
                Objects.equals(url, request.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(method, url);
    }
}
