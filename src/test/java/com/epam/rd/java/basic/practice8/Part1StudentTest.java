package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Part1StudentTest {

    @Test
    public void shouldInsertUser() throws SQLException {

        User user = new User();
        user.setLogin("Danya");

        DBManager dbManager = mock(DBManager.class);

        when(dbManager.getConnection("")).thenReturn(any(Connection.class));

    }

}