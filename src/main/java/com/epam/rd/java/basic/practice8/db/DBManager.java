package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class DBManager {

    private static final Logger LOGGER = Logger.getLogger(DBManager.class.getSimpleName());
    private static final String FILE_PROPERTIES = "app.properties";
    private static final String CONNECTION_URL_KEY_IN_FILE_PROPERTIES = "connection.url";
    private static final String CONNECTION_URL = getConnectionURL();
    private static DBManager dbManager;

    private DBManager() {
    }

    public static DBManager getInstance() {
        if(dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String connectionUrl) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.warning(e.getMessage());
        }

        return DriverManager.getConnection(connectionUrl);
    }

    ////////// Methods for User

    public void insertUser(User user){

        try(Connection connection = getConnection(CONNECTION_URL);
            Statement statement = connection.createStatement() ) {

            String sqlQuery = "INSERT INTO practice8.users (login) VALUES ('" + user.getLogin() + "')";

            statement.execute(sqlQuery);

        } catch (SQLException e) {
            LOGGER.warning(e.getMessage());
        }

    }

    public User getUser(String login){
        return null;
    }

    public List<User> findAllUsers() {
        return null;
    }

    ////////// Methods for Team

    public void insertTeam(Team team) {

    }

    public Team getTeam(String name) {
        return null;
    }

    public List<Team> findAllTeams() {
        return null;
    }

    public List<Team> getUserTeams(User user) {
        return null;
    }

    public void setTeamsForUser(User user, Team... teams) {

        for(Team team : teams) {

        }

    }

    public void deleteTeam(Team team) {

    }

    public void updateTeam(Team team) {

    }

    public static String getConnectionURL() {

        Properties properties = new Properties();
        File file = new File(FILE_PROPERTIES);

        try(FileReader fileReader = new FileReader(file)) {

            properties.load(fileReader);

        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }

        return properties.getProperty(CONNECTION_URL_KEY_IN_FILE_PROPERTIES);

    }

}
