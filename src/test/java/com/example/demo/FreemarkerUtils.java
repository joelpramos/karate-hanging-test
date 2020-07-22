package com.example.demo;

import freemarker.template.TemplateMethodModelEx;

import java.util.Map;
import java.util.UUID;

public class FreemarkerUtils {

    public static void addFreeMarkerUtils(Map<String, Object> data) {
        data.put("uuid", (TemplateMethodModelEx) (list) -> UUID.randomUUID());
    }

    public static void cleanUpFreeMarkerUuid(Map<String, Object> data) {
        data.put("uuid", null);
    }
}
