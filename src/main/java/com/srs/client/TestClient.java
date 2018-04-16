package com.srs.client;

import org.springframework.web.client.RestTemplate;

import com.srs.Alien;

public class TestClient {
public static void main(String[] args) {
	TestClient.AllAlien();
}

public static void OneAlien(){
String url="http://localhost:8080/rest/aliens/get/{id}";
RestTemplate rt=new RestTemplate();
Alien result=rt.getForObject(url, Alien.class,101);
System.out.println(result.getId());
System.out.println(result.getName());
}

public static void AllAlien(){
String url="http://localhost:8080/rest/aliens/all";
RestTemplate rt=new RestTemplate();
String entity=rt.getForObject(url, String.class);
System.out.println(entity);
}

}
