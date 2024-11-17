package com.xeno.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.xeno.entity.Customer;
import com.xeno.repo.CRepository;

@org.springframework.stereotype.Service
public class PostrmanService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CRepository repository;

    public void fetchDataFromApiAndSave() {
    	
        // Call the Postman API to fetch data
        String url = "https://api.example.com/endpoint";
        // replace with your Postman API endpoint

        Customer[] customers = restTemplate.getForObject(url, Customer[].class);
        if (customers != null) {
            repository.saveAll(List.of(customers));
        }
}
}