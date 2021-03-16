package org.dms.functionalprogramming.behaviour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ComparatorExampleTest {

    public static final String ORDERED = "ORDERED";
    public static final String UNORDERED = "UN" + ORDERED;
    private static Logger LOGGER = Logger.getLogger(ComparatorExampleTest.class.getName());
    private ComparatorExample comparatorExample;

    @BeforeEach
    public void setUp() {
        comparatorExample = new ComparatorExample();
        Client client1 = new Client("Ramon");
        Client client2 = new Client("Bruno");
        Client client3 = new Client("Julian");
        Client client4 = new Client("Alberto");
        Client client5 = new Client("Pedro");

        comparatorExample.clients.addAll(Arrays.asList(client1, client2, client3, client4, client5));
    }

    @Test
    @DisplayName("Comparando clientes usando Collections.sort")
    public void compareClientsOldWayTest() {
        logClientList(comparatorExample.clients, "Collections.sort " + UNORDERED);
        comparatorExample.compareClientsOldWay();
        logClientList(comparatorExample.clients, "Collections.sort " + ORDERED);
    }

    @Test
    @DisplayName("Comparando clientes usando Streams.sort")
    public void compareClientsNewWayTest() {
        logClientList(comparatorExample.clients, "Streams.sort " + UNORDERED);
        comparatorExample.compareClientsNewWay();
        logClientList(comparatorExample.clients, "Streams.sort " + ORDERED);
    }

    @Test
    @DisplayName("Comparando clientes usando method reference")
    public void compareClientsNewWayReferenceTest() {
        logClientList(comparatorExample.clients, "Method reference " + UNORDERED);
        comparatorExample.compareClientsNewWayReference();
        logClientList(comparatorExample.clients, "Method reference " + ORDERED);
    }

    private void logClientList(List<Client> clientList, String message) {
        int index;
        printSeparator(message);
        for(int i = 0; i < clientList.size(); i++) {
            index = i + 1;
            System.out.println(index + ". " + clientList.get(i).getName());
        }
    }

    private void printSeparator(String message) {
        System.out.println("================ " + message + " ===================");
    }
}
