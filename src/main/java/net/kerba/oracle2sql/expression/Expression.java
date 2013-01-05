package net.kerba.oracle2sql.expression;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 15:38
 */
public interface Expression<T> {
    public T eval();
}
