package com.hashringdemo;

public class Main {

    public static void main(String[] args) {
        Cluster c = createCluster();

        Entry[] entries = { new Entry("apple"),
                new Entry("applepen"),
                new Entry("pineapple"),
                new Entry("pineapplepen"),
                new Entry("PPAP")
            };

        for (Entry e : entries)
            c.put(e);

        findEnties(c, entries);

        c.addServer(new Server("192.168.0.5"));

        System.out.println("-----");
        findEnties(c, entries);

    }

    private static Cluster createCluster() {
        Cluster c = new Cluster();
        c.addServer(new Server("192.168.0.0"));
        c.addServer(new Server("192.168.0.1"));
        c.addServer(new Server("192.168.0.2"));
        c.addServer(new Server("192.168.0.3"));
        return c;
    }

    private static void findEnties(Cluster c, Entry[] entries) {
        for (Entry e : entries) {
            if (e == c.get(e)) {
                System.out.println("重新找到了entry:" + e);
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }
}
