package com.example.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController

public class SearchControllers {
    @GetMapping()
    public Boolean deneme(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Hedef URL oluşturuluyor
            String url = "http://localhost:8080/categories";
            URL obj = new URL(url);

            // HttpURLConnection nesnesi oluşturuluyor
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // GET isteği ayarlanıyor
            connection.setRequestMethod("GET");

            // Yanıt kodunu kontrol etmek için bağlantı yapılıyor
            int responseCode = connection.getResponseCode();
            System.out.println("GET isteği gönderiliyor: " + url);
            System.out.println("Yanıt Kodu: " + responseCode);

            // Yanıtı okuma
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();//String buffer ile string farkı nedir? String BUilder?

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Yanıtı yazdırma
            System.out.println("Yanıt: " + response.toString());
            List<Categories> categoriesList = objectMapper.readValue(response.toString(), new TypeReference<List<Categories>>(){});
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
