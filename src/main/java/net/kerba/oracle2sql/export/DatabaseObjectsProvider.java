package net.kerba.oracle2sql.export;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 20:25
 */

public interface DatabaseObjectsProvider extends Exportable {
    /**
     * fetches objects to be exported from database, i.e. list of tables/views etc.
     */
    public void fetch(DataSource dataSource) throws SQLException;

}
