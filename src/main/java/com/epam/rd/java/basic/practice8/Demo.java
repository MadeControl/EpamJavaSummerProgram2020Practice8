package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.util.List;

public class Demo {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

//    public static void main(String[] args) {
//
//        // users  ==> [ivanov]
//
//        // teams ==> [teamA]
//
//        DBManager dbManager = DBManager.getInstance();
//
//        // Part 1
//
//        dbManager.insertUser(User.createUser("petrov"));
//
//        dbManager.insertUser(User.createUser("obama"));
//
//        printList(dbManager.findAllUsers());
//
//        // users  ==> [ivanov, petrov, obama]
//
//        System.out.println("===========================");
//
//        // Part 2
//
//        dbManager.insertTeam(Team.createTeam("teamB"));
//
//        dbManager.insertTeam(Team.createTeam("teamC"));
//
//        printList(dbManager.findAllTeams());
//
//        // teams ==> [teamA, teamB, teamC]
//
//        System.out.println("===========================");
//
//        // Part 3
//
//        User userPetrov = dbManager.getUser("petrov");
//
//        User userIvanov = dbManager.getUser("ivanov");
//
//        User userObama = dbManager.getUser("obama");
//
//        Team teamA = dbManager.getTeam("teamA");
//
//        Team teamB = dbManager.getTeam("teamB");
//
//        Team teamC = dbManager.getTeam("teamC");
//
//        // method setTeamsForUser must implement transaction!
//
//        dbManager.setTeamsForUser(userIvanov, teamA);
//        dbManager.setTeamsForUser(userPetrov, teamA, teamB);
//        dbManager.setTeamsForUser(userObama, teamA, teamB, teamC);
//
//        for (User user : dbManager.findAllUsers()) {
//
//            printList(dbManager.getUserTeams(user));
//
//            System.out.println("~~~~~");
//
//        }
//
//        System.out.println("===========================");
//
//        // Part 4
//
//        // on delete cascade!
//
//        dbManager.deleteTeam(teamA);
//
//        // Part 5
//
//        teamC.setName("teamX");
//
//        dbManager.updateTeam(teamC);
//
//        printList(dbManager.findAllTeams());    // teams ==> [teamB, teamX]
//
//    }

    public static void main(String[] args) {

        DBManager dbManager = DBManager.getInstance();

//        User user = new User();
//        user.setLogin("vasya");
//        dbManager.insertUser(user);

        User user1 = dbManager.getUser("vasya");
        System.out.println(user1);

        List<User> list = dbManager.findAllUsers();
        System.out.println(list);

        Team team = new Team("team1");
        dbManager.insertTeam(team);

        Team team1 = dbManager.getTeam("team1");
        System.out.println(team1);

        List<Team> list1 = dbManager.findAllTeams();
        System.out.println(list1);

        dbManager.setTeamsForUser(user1, team1);
        System.out.println(dbManager.getUserTeams(user1));

        team1.setName("2222");
        dbManager.updateTeam(team1);
        System.out.println(dbManager.findAllTeams());

        dbManager.deleteTeam(team1);
        System.out.println(dbManager.findAllTeams());

    }

}