package com.example.cloud.service;

import com.example.cloud.domain.Account;
import com.example.cloud.domain.Client;
import com.example.cloud.domain.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountsService {

    private static List<Account> accounts = List.of (
                new Account ("A100", "C100", Currency.CAD, 100.00F, "A"),
                new Account ("A101", "C100", Currency.SGD, 110.00F, "S"),
                new Account ("A102", "C101", Currency.USD, 200.00F, "I")
            );

    private static List<Client> clients = List.of(
      new Client ("C100", "Santhosh", "Krishnan", "P"),
      new Client ("C101", "Surekha", "Thoduvayil", "")
    );

    public List<Account> getAccounts() {
        return accounts;
    }

    public Client getClientByAccountId(String accountId) {
        Client client = clients.stream()
                .filter(c->c.clientId().equals(
                        getAccounts().stream().filter(a->a.id().equals(accountId)).findFirst().get().clientId())
                )
                .findFirst().get();
        log.info("Client : " + client);
        return client;
    }
}
