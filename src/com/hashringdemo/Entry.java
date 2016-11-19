package com.hashringdemo;

public class Entry {
    private String key;

    Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    public int hashCode() {
        return key.hashCode();
    }
}
