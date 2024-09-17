package com.example.cloud.controller;

import com.example.cloud.domain.Address;
import com.example.cloud.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class AddressController {

    @Autowired
    AddressService service;


    @QueryMapping
    List<Address> address (String clientId) {
        log.info("Retrieving Address");
        return service.getAddress (clientId);
    }
}
