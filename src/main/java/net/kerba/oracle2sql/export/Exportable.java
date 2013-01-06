package net.kerba.oracle2sql.export;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 15:11
 */


/**
 * any object implemented this interfaces could be exported
 */
public interface Exportable {

    /**
     * returns if this type of object should be exported
     * @return true, if object should be exported, false otherwise
     */
    public boolean isExportable();

    /**
     * returns SQL string for object creation
     * @return DDL SQL script for object
     */
    public String export();
}
