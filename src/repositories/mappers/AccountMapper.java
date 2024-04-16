package repositories.mappers;

import models.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper {

    // Map a ResultSet to an Account object
    public Account mapFromResultSet(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new Account(username, password);
    }

    // Map an Account object to a PreparedStatement
    public void mapToPreparedStatement(Account account, PreparedStatement statement) throws SQLException {
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getPassword());
    }
}
