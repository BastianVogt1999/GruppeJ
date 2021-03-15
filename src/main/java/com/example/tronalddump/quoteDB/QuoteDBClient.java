package com.example.tronalddump.quoteDB;


import com.example.tronalddump.quoteDB.quoteObject.QuoteObj;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class QuoteDBClient {

    public QuoteObj getData(String tag) {

        String url = "https://www.tronalddump.io/search/quote?";


        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", tag);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<QuoteObj> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, QuoteObj.class);

        return response.getBody();
    }
}
