package com.example.cloud.controller;

import com.example.cloud.domain.Account;
import com.example.cloud.domain.Client;
import com.example.cloud.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class AccountController {

    @Autowired
    AccountsService service;


    @QueryMapping
    List<Account> accounts () {
        log.info("Retrieving Accounts");
        return service.getAccounts ();
    }

    @BatchMapping (field = "client", typeName = "Account")
    List<Client> getClients (List<Account> accounts) {
        log.info("Retrieving Clients for : " + accounts);

        List<Client> clients =  accounts.stream()
                .map(a-> service.getClientByAccountId(a.id()))
                    .collect(Collectors.toList());
        return clients;
    }

    /*@SchemaMapping (field = "client", typeName = "Account")
    Client getClients (Account account) {
        log.info("Retrieving Clients for : " + account.id());
        return service.getClientByAccountId (account.id());
    }*/
}
