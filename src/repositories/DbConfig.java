package repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// DbConfig configures Database Connection
public class DbConfig {
    private static final String INIT_SCRIPT_PATH = "src/init_script.sql";

    public static Connection getConnection() {
        try {
            Properties properties = loadProperties();
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, user, password);
        } catch (IOException |SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    public static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new IOException("Failed to load properties file", e);
        }
        return properties;
    }


    public static void initializeDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sqlScript = new String(Files.readAllBytes(Paths.get(INIT_SCRIPT_PATH)));
            String[] sqlStatements = sqlScript.split(";");

            for (String sql : sqlStatements) {
                statement.addBatch(sql.trim());
            }
            statement.executeBatch();
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }


}
