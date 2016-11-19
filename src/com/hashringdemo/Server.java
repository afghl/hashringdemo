package com.hashringdemo;

import java.util.LinkedList;
import java.util.List;

public class Server {
    private String name;
    private List<Entry> entries;

    Server() {
        entries = new LinkedList<Entry>();
    }

    // 使用FNV1_32_HASH算法计算服务器的Hash值。
    @Override
    public int hashCode() {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < name.length(); i++)
            hash = (hash ^ name.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        return Math.abs(hash);
    }
}
