package net.kerba.oracle2sql;

import net.kerba.oracle2sql.config.Configuration;
import net.kerba.oracle2sql.config.DefaultConfiguration;
import net.kerba.oracle2sql.export.DatabaseObjectsProvider;
import net.kerba.oracle2sql.export.Tables;
import net.kerba.oracle2sql.expression.ElBooleanExpression;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 1:20
 */
public class OracleExport {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        Configuration config = new DefaultConfiguration();

        List<DatabaseObjectsProvider> objectTypesToExport = new ArrayList<DatabaseObjectsProvider>();

        objectTypesToExport.add(new Tables(new ElBooleanExpression("${f:contains(object.name,'TYPE')}")));

        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();


            for(DatabaseObjectsProvider i : objectTypesToExport) {
                i.fetch(ods);
                i.export();
            }

//            System.out.println(tables);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("Time in seconds: %10.3f", (System.currentTimeMillis() - started) / 1000.0));
    }
}
