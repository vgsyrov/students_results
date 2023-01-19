package com.journal.resultscontrolapigateway;

import java.util.Map;

import static java.util.Map.entry;

public class AttendanceFactMapper {

    private static final Map<String, String> mapper = Map.ofEntries(
            entry("П", "PRESENT"),
            entry("Н", "ABSENT")
            );

    public static String mapValue(String value){
        return mapper.get(value);
    }
}
