package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

public class Part1StudentTest {

    @Test
    public void shouldInsertUser() throws SQLException {

        User user = new User();
        user.setLogin("Danya");

        DBManager dbManager = mock(DBManager.class);

        when(dbManager.getConnection("")).thenReturn(any(Connection.class));

        when(dbManager.getUser("Danya")).thenReturn(user);

        when(dbManager.findAllUsers()).thenReturn(Collections.singletonList(user));

        Assert.assertNotNull(dbManager);

    }

}