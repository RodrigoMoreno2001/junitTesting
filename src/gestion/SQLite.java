package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite implements AutoCloseable{

    private Connection connection;
    private final String bd = "ingresos.db";

    /**
     * Crea la conexión a la base de datos
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public SQLite() throws SQLException, ClassNotFoundException {
        //abra la conexión directaments desde el constructor
        connection = DriverManager.getConnection("jdbc:sqlite:"+bd);
    }

    public void inicio() throws SQLException{
        Statement statement = connection.createStatement();

        // Corrected CREATE TABLE statements
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios ("
                + "DNI TEXT PRIMARY KEY,"
                + "nombre TEXT,"
                + "saldo INTEGER"
                + ")");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS movimientos ("
                + "id INTEGER PRIMARY KEY,"
                + "DNI TEXT,"
                + "tipo TEXT,"
                + "saldo INTEGER"
                + ")");

        // Corrected SELECT query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");

        // Insert data if the table is empty
        if (!resultSet.next()) { // Check if ResultSet is empty
            statement.executeUpdate("INSERT INTO usuarios (DNI, nombre, saldo) VALUES ('55930437A', 'Manolo', 28000)");
            statement.executeUpdate("INSERT INTO usuarios (DNI, nombre, saldo) VALUES ('25138957A', 'Fernando', 280000)");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Cierra la conexión. Este metodo es llamado automáticamente al usar try-with-resources.
     *
     * @throws SQLException
     */
    @Override
    public void close() throws SQLException {
        connection.close();
    }
}