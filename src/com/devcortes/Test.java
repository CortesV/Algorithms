package com.devcortes;

import java.util.Collection;
import java.util.Optional;

public class Test {
}

interface ConnectionPool {
    Connection getConnection();
}

interface Connection extends AutoCloseable {
    void executeQuery(String query);
}

class SimpleConnectionPool implements ConnectionPool {

    private Collection<Connection> poolConnections;

    public SimpleConnectionPool(Collection<Connection> connections) {
        this.poolConnections = connections;
    }

    @Override
    public Connection getConnection() {
        Optional<Connection> connection = poolConnections.stream().findFirst();
        if (connection.isPresent()) {
            poolConnections.remove(connection.get());
            return connection.get();
        }
        return null;
    }

    public void returnConnection(Connection connection) {
        poolConnections.add(connection);
    }
}
