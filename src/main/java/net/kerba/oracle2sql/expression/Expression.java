package net.kerba.oracle2sql.expression;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 15:38
 */
public interface Expression {
    public <T> T eval(Map contextValues,Class<T> desiredType);

}
