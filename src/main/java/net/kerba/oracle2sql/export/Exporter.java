package net.kerba.oracle2sql.export;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 15:11
 */
public interface Exporter {
    public boolean isExportable();

    public String export();
}
