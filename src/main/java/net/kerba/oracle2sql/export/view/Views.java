package net.kerba.oracle2sql.export.view;

import net.kerba.oracle2sql.export.DatabaseObjectsProvider;
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
public class Views implements DatabaseObjectsProvider {
    private Expression viewsExportableExpression;

    private List<View> views;

    public Views(Expression viewsExportableExpression) {
        Check.notNull(viewsExportableExpression, "viewsExportableExpression");
        this.viewsExportableExpression = viewsExportableExpression;
    }

    public Views(String expressionString) {
        Check.notNull(expressionString,"expressionString");
        this.viewsExportableExpression = new ElBooleanExpression(expressionString);
    }

    @Override
    public boolean isExportable() {
        return false;
    }

    @Override
    public String export() {
        for(View i : views) {
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

        ResultSetHandler<List<View>> rsh = new ResultSetHandler<List<View>>() {
            @Override
            public List<View> handle(ResultSet rs) throws SQLException {
                List<View> list = new ArrayList<View>();
                while (rs.next()) {
                    list.add(new View(rs.getString("VIEW_NAME"), viewsExportableExpression));
                }
                return list;
            }
        };

        views = qr.query("SELECT * FROM user_views",rsh);
    }

    @Override
    public String toString() {
        return views != null ? views.toString() : "null";
    }
}
