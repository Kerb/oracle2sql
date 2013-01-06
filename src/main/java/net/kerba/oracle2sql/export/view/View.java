package net.kerba.oracle2sql.export.view;

import net.kerba.oracle2sql.export.Exportable;
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
public class View implements Exportable {
    private String viewname;

    private Expression viewExportableExpression;

    public View(String viewname,
                Expression tableExportable) {
        Check.notNull(viewname, "viewname");
        Check.notNull(tableExportable, "tableExportable");

        this.viewname = viewname;
        this.viewExportableExpression = tableExportable;
    }

    @Override
    public boolean isExportable() {
        Map<String,Object> tableProperties = new HashMap<String, Object>();
        tableProperties.put("name", viewname);

        return viewExportableExpression.eval(tableProperties,Boolean.class);
    }

    @Override
    public String export() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("View '%s'", viewname);
    }

}
