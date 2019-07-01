package com.example.retrofit;

public class Obj {
  String name,timestamp;
  Obj2 url;

    public Obj(String name, String timestamp, Obj2 url) {
        this.name = name;
        this.timestamp = timestamp;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Obj2 getUrl() {
        return url;
    }

    public void setUrl(Obj2 url) {
        this.url = url;
    }
}
