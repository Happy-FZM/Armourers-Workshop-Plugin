package moe.plushie.armourers_workshop.core.data.source;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class SQLTableBuilder {

    private final String name;
    private final LinkedHashMap<String, String> fields = new LinkedHashMap<>();

    public SQLTableBuilder(String name) {
        this.name = name;
    }

    public void add(String name, String type) {
        fields.put(name, type);
    }

    public int execute(Connection connection) throws SQLException {
        // check the table exists.
        int count = 0;
        String catalog = connection.getCatalog();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet result = metaData.getTables(catalog, null, name, null)) {
            if (!result.next()) {
                // create a table when not exists.
                StringJoiner joiner = new StringJoiner(", ", String.format("CREATE TABLE `%s` (", name), ")");
                for (Map.Entry<String, String> entry : fields.entrySet()) {
                    joiner.add(String.format("`%s` %s", entry.getKey(), entry.getValue()));
                }
                return execute(connection, joiner.toString());
            }
        }
        // check the table fields exists.
        StringJoiner joiner = new StringJoiner(";");
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            try (ResultSet result = metaData.getColumns(catalog, null, name, entry.getKey())) {
                if (!result.next()) {
                    joiner.add(String.format("ALTER TABLE `%s` ADD COLUMN `%s` %s", name, entry.getKey(), entry.getValue()));
                    count += 1;
                }
            }
        }
        if (count != 0) {
            return execute(connection, joiner.toString());
        }
        return 0;
    }

    private int execute(Connection connection, String sql) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeUpdate(sql);
        }
    }
}
