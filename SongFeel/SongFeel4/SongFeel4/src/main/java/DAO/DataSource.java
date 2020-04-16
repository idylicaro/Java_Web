package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private String hostname;
    private String username;
    private String passowrd;
    private String database;
    private Connection connection;

    public DataSource(){
        try{
            hostname = "localhost";
            database = "temspotify";
            username = "songfeel";
            passowrd = "idylicaro1";
            /**
             *
             * Obs: Pode ocorrer problema com FUSO horario.
             */
            String URL = "jdbc:mysql://localhost:3306/temspotify?useTimezone=true&serverTimezone=UTC";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(URL, username, passowrd);
            System.out.println("DataSource Connected");
        }catch (SQLException ex){
            System.out.println("ERRO ao Conectar:"+ ex.getMessage());
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
}
