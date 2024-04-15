package repositories;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DbConfigTest {

    @Test
    void testGetConnection() {
        Connection connection = DbConfig.getConnection();
        assertNotNull(connection, "Connection should not be null");
    }
}