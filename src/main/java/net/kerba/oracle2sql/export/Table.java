package net.kerba.oracle2sql.export;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 22:27
 */
public class Table implements Exportable {
    private String tablename;

    public Table(String tablename) {
        this.tablename = tablename;
    }

    @Override
    public boolean isExportable() {
        return false;
    }

    @Override
    public String export() {
        return null;
    }

    @Override
    public String toString() {
        return tablename;
    }
}
