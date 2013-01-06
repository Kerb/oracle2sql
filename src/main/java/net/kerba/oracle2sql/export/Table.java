package net.kerba.oracle2sql.export;

import net.kerba.oracle2sql.expression.Expression;
import net.kerba.utils.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 22:27
 */
public class Table implements Exportable {
    private String tablename;

    private Expression tableExportableExpression;

    public Table(String tablename,
                 Expression tableExportable) {
        Check.notNull(tablename, "tablename");
        Check.notNull(tableExportable, "tableExportable");

        this.tablename = tablename;
        this.tableExportableExpression = tableExportable;
    }

    @Override
    public boolean isExportable() {
        Map<String,Object> tableProperties = new HashMap<String, Object>();
        tableProperties.put("name", tablename);

        return tableExportableExpression.eval(tableProperties,Boolean.class);
    }

    @Override
    public String export() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("Table '%s'",tablename);
    }

}
