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

        Configuration.Facade configFacade = DefaultConfiguration.facade();

        List<DatabaseObjectsProvider> objectTypesToExport = new ArrayList<DatabaseObjectsProvider>();

//        objectTypesToExport.add(new Tables(new ElBooleanExpression("${not f:startsWith(object.name,'H#')}")));
        objectTypesToExport.add(new Tables(configFacade.getString(Configuration.Param.FILTER_TABLE)));


        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();
            ods.setUser("DOF_USER");
            ods.setURL("jdbc:oracle:thin:@192.168.102.53:1521:DOFDB");
            ods.setPassword("japan#2030");


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
