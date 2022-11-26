package utils;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe per aprire una connessione con il database Mysql
 */
public class DbUtil {
    private Connection con;
    private String serverName, user, password, nomeDatabase;
    private int portNumber;

    public DbUtil() {
    }

    /*Leggo il file properties jdbc.properties*/
    {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        serverName = rb.getString("jdbc.serverName");
        portNumber = Integer.parseInt(rb.getString("jdbc.portNumber"));
        user = rb.getString("jdbc.user");
        password = rb.getString("jdbc.password");
        nomeDatabase = rb.getString("jdbc.nomeDatabase");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(serverName);
            dataSource.setPortNumber(portNumber);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setDatabaseName(nomeDatabase);
            con = dataSource.getConnection();
        }
        return con;
    }
}
