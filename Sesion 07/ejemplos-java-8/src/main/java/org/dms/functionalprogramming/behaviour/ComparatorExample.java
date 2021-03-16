package org.dms.functionalprogramming.behaviour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    List<Client> clients = new ArrayList<>();

    void compareClientsOldWay() {
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return client1.getName().compareTo(client2.getName());
            }
        });
    }

    void compareClientsNewWay() {
        clients.sort(Comparator.comparing(client -> client.getName()));
    }

    void compareClientsNewWayReference() {
        clients.sort(Comparator.comparing(Client::getName));
    }


}
