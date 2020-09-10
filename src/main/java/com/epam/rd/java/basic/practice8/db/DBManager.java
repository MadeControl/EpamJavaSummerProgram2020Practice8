package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class DBManager {

    private static final String FILE_PROPERTIES = "app.properties";
    private static DBManager dbManager;

    private DBManager() {
    }

    public static DBManager getInstance() {
        if(dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String connectionUrl) throws SQLException, IOException {

        Properties properties = new Properties();
        File file = new File(FILE_PROPERTIES);
        FileReader fileReader = new FileReader(file);

        properties.load(fileReader);

        String urlDataBase = properties.getProperty(connectionUrl);

        return DriverManager.getConnection(urlDataBase);
    }

    ////////// Methods for User

    public void insertUser(User user){

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection("");
            statement = connection.createStatement();

            String sqlQuery = "INSERT INTO practice8.users (login) VALUES ('" + user.getLogin() + "')";

            statement.execute(sqlQuery);

            statement.close();
            connection.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
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

}
