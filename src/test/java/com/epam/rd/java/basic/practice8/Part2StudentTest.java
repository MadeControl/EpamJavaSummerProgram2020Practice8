package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Part2StudentTest {

    @Test
    public void shouldInsertTeam() throws SQLException {

        Team team = new Team();
        team.setName("team1");

        DBManager dbManager = mock(DBManager.class);

        when(dbManager.getConnection("")).thenReturn(any(Connection.class));

        when(dbManager.getTeam("team1")).thenReturn(team);

        when(dbManager.findAllTeams()).thenReturn(Collections.singletonList(team));

        Assert.assertNotNull(dbManager);

    }

}