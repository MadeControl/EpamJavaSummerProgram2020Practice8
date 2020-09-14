package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class Part3StudentTest {

    @Test
    public void shouldSetTeamsForUser() {

        User user = new User();
        user.setLogin("Danya");

        Team team = new Team();
        team.setName("team1");

        DBManager dbManager = mock(DBManager.class);

        when(dbManager.getUserTeams(user)).thenReturn(Collections.singletonList(team));

        Assert.assertNotNull(dbManager);

    }
}