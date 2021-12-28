package com.skillfactory.utils;

import org.apache.commons.collections.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RandomUserRequester {
    private static final String USER_API_URL = "https://randomuser.me/api";

    public static String requestUser(List<Parameter> parameters) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(getParametrisedString(USER_API_URL, parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode() == 200) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
        }
        return response.toString();
    }

    private static String getParametrisedString(String url, List<Parameter> parameters) {
        if (CollectionUtils.isEmpty(parameters)) {
            return url;
        }
        StringBuilder result = new StringBuilder(url + "?");

        for (Parameter parameter : parameters) {
            result.append(parameter.getKey());
            result.append("=");
            result.append(parameter.getValue());
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
