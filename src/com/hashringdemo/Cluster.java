package com.hashringdemo;

public class Cluster {
    private static final int SERVER_SIZE_MAX = 1024;

    private Server[] servers = new Server[SERVER_SIZE_MAX];
    private int size = 0;

    public void put(Entry e) {
        routeServer(e.hashCode()).put(e);
    }

    public Entry get(Entry e) {
        return routeServer(e.hashCode()).get(e);
    }

    public Server routeServer(int hash) {
        return servers[hash % size];
    }

    public boolean addServer(Server s) {
        if (size >= SERVER_SIZE_MAX)
            return false;

        servers[size++] = s;
        return true;
    }
}
