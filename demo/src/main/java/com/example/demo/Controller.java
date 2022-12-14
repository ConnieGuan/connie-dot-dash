package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    // AKA: the server
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Object>> search(String query, String sortField) {
        String uri = "https://www.goodreads.com/search/index.xml";
        RestTemplate template = new RestTemplate();

        // NOTE: I actually was not able to get the GoodReads API working even with a curl command from
        // my terminal or a postman request. Likely I'm not generating the correct query...

        Map<String, String> map = new HashMap();
        map.put("key", "RDfV4oPehM6jNhxfNQzzQ");
        map.put("q", query);

        try {
            Object[] result = template.getForObject(uri, Object[].class, map);

            // NOTE: I would create some kind of model class to represent the search results returned by the
            // GoodReads API (unfortunately I was not able to generate one to be able to see what the response looks like)
            // and then sort on that, based off the results of sortField.

            return ResponseEntity.ok(Arrays.asList(result));

        } catch (Exception e) {

            // if any exception occurs in requesting the API catch it and rethrow a DemoException
            // The ExceptionHandler class will handle this exception and print a string that
            throw new DemoException();
        }




    }

}
