package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {

    private final Connection connection;

    public HistoryRepository() {
        this.connection = DbConfig.getConnection();
    }
    public Object[][] getHistory(String username) {
        List<Object[]> history = new ArrayList<>();
        String selectQuery = "SELECT games.date, " +
                "CASE " +
                "WHEN games.result = 'RED_WIN' AND (accounts.username = redTeam.spymaster OR accounts.username = redTeam.operative) THEN 'WIN' " +
                "WHEN games.result = 'BLUE_WIN' AND (accounts.username = blueTeam.spymaster OR accounts.username = blueTeam.operative) THEN 'WIN' " +
                "ELSE 'LOSE' " +
                "END AS result, " +
                "CASE " +
                "WHEN accounts.username = redTeam.spymaster or accounts.username = blueTeam.spymaster THEN 'SPYMASTER' " +
                "WHEN accounts.username = redTeam.operative or accounts.username = blueTeam.operative THEN 'OPERATIVE' " +
                "END AS role " +
                "FROM history " +
                "INNER JOIN games ON history.gameId = games.gameId " +
                "INNER JOIN teams AS redTeam ON games.redTeam = redTeam.teamId " +
                "INNER JOIN teams AS blueTeam ON games.blueTeam = blueTeam.teamId " +
                "INNER JOIN accounts ON " +
                "(accounts.username = redTeam.spymaster OR accounts.username = redTeam.operative OR " +
                "accounts.username = blueTeam.spymaster OR accounts.username = blueTeam.operative) " +
                "WHERE accounts.username = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String date = resultSet.getString("date");
                    String result = resultSet.getString("result");
                    String role = resultSet.getString("role");
                    history.add(new Object[]{date, role, result});
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return history.toArray(new Object[0][]);
    }


    public void insertHistory(String account, int gameId) {
        String insertQuery = "INSERT INTO history (account, gameId) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, account);
            statement.setInt(2, gameId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
