package net.kerba.oracle2sql;

import net.kerba.oracle2sql.config.Configuration;
import net.kerba.oracle2sql.config.DefaultConfiguration;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 1:20
 */
public class OracleExport {
    public static void main(String[] args) {
        Configuration config = new DefaultConfiguration();

        System.out.println("db: " + config.getParameter(Configuration.Param.CONNECT_DB).eval());
        System.out.println("host: " + config.getParameter(Configuration.Param.CONNECT_HOST).eval());
        System.out.println("filter column: " + config.getParameter(Configuration.Param.FILTER_COLUMN).eval());

    }
}
