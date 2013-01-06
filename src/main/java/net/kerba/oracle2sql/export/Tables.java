package net.kerba.oracle2sql.export;

import net.kerba.oracle2sql.config.Configuration;
import net.kerba.oracle2sql.expression.ElBooleanExpression;
import net.kerba.oracle2sql.expression.Expression;
import net.kerba.utils.Check;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 20:22
 */
public class Tables implements Exportable, DatabaseObjectsProvider {
    private Expression<Boolean> tableExportableExpression;

    private List<Table> tables;

    public Tables(Expression<Boolean> tableExportableExpression) {
        Check.notNull(tableExportableExpression, "tableExportableExpression");
        this.tableExportableExpression = tableExportableExpression;
    }

    @Override
    public boolean isExportable() {
        return false;
    }

    @Override
    public String export() {
        for(Table i : tables) {
            if (i.isExportable()) {
                System.out.println(String.format("%s to be exported",i.toString()) );
            } else {
                System.out.println(String.format("Ignoring %s",i.toString()) );
            }
        }
        return null;
    }

    @Override
    public void fetch(DataSource dataSource) throws SQLException {
        QueryRunner qr = new QueryRunner(dataSource);

        ResultSetHandler<List<Table>> rsh = new ResultSetHandler<List<Table>>() {
            @Override
            public List<Table> handle(ResultSet rs) throws SQLException {
                List<Table> list = new ArrayList<Table>();
                while (rs.next()) {
                    list.add(new Table(rs.getString("TABLE_NAME"), tableExportableExpression));
                }
                return list;
            }
        };

        tables = qr.query("SELECT * FROM user_tables",rsh);
    }

    @Override
    public String toString() {
        return tables != null ? tables.toString() : "null";
    }
}
