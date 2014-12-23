package ml.tchat.plugins.bot;

import java.sql.*;

/**
 * Created by justin on 23/12/2014.
 */
public class DatabaseHelper {
    Connection connect(String path) throws SQLException, ClassNotFoundException, NullPointerException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        return connection;
    }

    /**
     * @param connection , the connection to a database, {@link #connect(String)}
     * @param timeout    , the timeout for the query
     *                   {@link Statement#setQueryTimeout(int)}
     * @return Returns a {@link Statement}
     * @throws SQLException
     */
    public Statement state(Connection connection, int timeout) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(timeout); // set timeout to 30 sec.
        return statement;
    }

    /**
     * @param connection , the connection to a database, {@link #connect(String)}
     * @return Returns a {@link Statement}
     * @throws SQLException
     */
    public Statement state(Connection connection) throws SQLException {
        return state(connection, 30); // set timeout to 30 sec.

    }

    /**
     * @param statement
     * @param table_name
     * @param column_names
     * @param data_types
     * @throws SQLException
     */
    void createTable(Statement statement, String table_name, String[] column_names, String[] data_types) throws SQLException {
        if(column_names.length != data_types.length){
            throw new SQLException("Amount of fields and amount of data types do not match. This is an error");
        }
        String query = "create table if not exists " + table_name + " (";
        for (int i = 0; i < column_names.length; i++) {
            query = query + column_names[i] + " " + data_types[i];
            if(column_names.length != i+1){
                query = query + ", ";
            }
        }
        query = query + ")";
        statement.executeUpdate(query);
    }
    /**
     *
     * @param statement
     * @param query
     * @return
     * @throws SQLException
     */
    public static ResultSet rs(Statement statement, String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }
}
