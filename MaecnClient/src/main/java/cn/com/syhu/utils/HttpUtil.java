package cn.com.syhu.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class HttpUtil {

    private static final OkHttpClient CLIENT = new OkHttpClient();

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
