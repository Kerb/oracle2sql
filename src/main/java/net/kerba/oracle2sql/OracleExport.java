package net.kerba.oracle2sql;

import net.kerba.oracle2sql.config.Configuration;
import net.kerba.oracle2sql.config.DefaultConfiguration;
import net.kerba.oracle2sql.export.Table;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
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
        Configuration config = new DefaultConfiguration();

        ResultSetHandler<List<Table>> handler = new ResultSetHandler<List<Table>>() {
            @Override
            public List<Table> handle(ResultSet rs) throws SQLException {
                List<Table> result = new ArrayList<Table>();
                while(rs.next()) {
                    result.add(new Table(rs.getString("TABLE_NAME")));
                }
                return result;
            }
        };

        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();
            ods.setUser("DOF_USER");
            ods.setURL("jdbc:oracle:thin:@192.168.102.:1521:");

            QueryRunner qr = new QueryRunner(ods);
            List<Table> result = qr.query("SELECT * FROM user_tables", handler);

            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
