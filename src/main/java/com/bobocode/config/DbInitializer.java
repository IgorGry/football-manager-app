package com.bobocode.config;

import com.util.FileReader;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DbInitializer {
    private final static String TABLE_INITIALIZATION_SQL_FILE = "db/migration/table_initialization.sql"; // todo: see the file
    private DataSource dataSource;

    public DbInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Reads the SQL script form the file and executes it
     *
     * @throws SQLException
     */
    public void init() throws SQLException {
        String createTablesSql = FileReader.readWholeFileFromResources(TABLE_INITIALIZATION_SQL_FILE);

        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(createTablesSql);
        }
    }
}
