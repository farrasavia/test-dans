package com.farras.testdans.testApi;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/test-controller")
public class TestController {

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

  @GetMapping("/getAllRestTemplate")
  public ResponseEntity<ArrayList> getAllRestTemplate() {
    String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
    RestTemplate restTemplate1 = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<ArrayList> response = restTemplate1.exchange(url, HttpMethod.GET, entity, ArrayList.class);
    return response;
  }

  @GetMapping("/getRestTemplateById/{id}")
  public ResponseEntity<String> getRestTemplateById(@PathVariable(value = "id") String id)
  {
    String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id;
    RestTemplate restTemplate1 = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<String> response = restTemplate1.exchange(url, HttpMethod.GET, entity, String.class);
    return response;
  }
}
