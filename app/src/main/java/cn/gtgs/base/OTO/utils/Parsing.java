package cn.gtgs.base.OTO.utils;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import cn.gtgs.base.OTO.activity.login.model.Account;
import okhttp3.Response;

/**
 * Created by gtgs on 2017/2/17.
 */

public class Parsing {
    public static Account ResponseToLogin(Response response) {
        Account account = null;
        try {
            String Str = response.body().string();
//        String Str = "{\n" +
//                "\"token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9vMm8uY29tIiwiaWF0IjoxNDg0ODcyMjMxLCJuYmYiOjE0ODQ4NzIyMzEsImV4cCI6MTQ4NTQ3NzAzMSwiZGF0YSI6eyJ1c2VyIjp7ImlkIjoiMTcifX19.rlyo2_yyqbXfM8uKZMlePMIZulpLf4u1QunSDL7B4PM\",\n" +
//                "\"user_email\": \"99@g.com\",\n" +
//                "\"user_nicename\": \"99g-com\",\n" +
//                "\"user_display_name\": \"99@g.com\"\n" +
//                "}";
            JSON json = JSON.parseObject(Str);
            account = json.toJavaObject(Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }
}
