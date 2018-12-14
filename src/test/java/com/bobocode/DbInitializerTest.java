package com.bobocode;

import com.bobocode.config.DbInitializer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;

public class DbInitializerTest {
    @Autowired
    private static DataSource dataSource;
    @BeforeClass
    public static void init() throws SQLException {
        DbInitializer dbInitializer = new DbInitializer(dataSource);
        dbInitializer.init();
    }
    @Test
    public void testDbInit(){

    }
}
