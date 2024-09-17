package com.example.cloud.service;

import com.example.cloud.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private List<Address> allAddresses = List.of(
            new Address("1", "C100", "123 Maple St", "Toronto", "ON", "M5H 2N2", "Canada"),
            new Address("2", "C101", "456 Oak St", "Vancouver", "BC", "V6B 1A1", "Canada"),
            new Address("3", "C102", "789 Pine St", "Montreal", "QC", "H2Y 1J7", "Canada"),
            new Address("4", "C103", "101 Birch St", "Calgary", "AB", "T2P 1J4", "Canada")
    );

    public List<Address> getAddress(String clientId) {
        return allAddresses.stream()
                .filter(address -> address.clientId().equals(clientId))
                .collect(Collectors.toList());
    }
}
