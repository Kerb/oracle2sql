package net.kerba.oracle2sql.expression;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 19:54
 */
public class ConstantValueExpression implements Expression {
    private Object value;

    public ConstantValueExpression(Object value) {
        this.value = value;
    }

    @Override
    public Object eval(Map contextValues) {
        return value;
    }
}
