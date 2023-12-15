package com.xyx.xuexi;

import java.util.HashMap;
import java.util.Map;

public class PutTest {
    public static void main(String[] args) {
        Map<String, String> inspectConclusionMap = new HashMap<>();
        inspectConclusionMap.put("JYJL","1");
        inspectConclusionMap.put("JYJL","2");
        System.out.printf(inspectConclusionMap.get("JYJL"));

//        String mark = "";
//        System.out.println(!mark.isEmpty());
    }
}
