package net.kerba.oracle2sql.expression;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 15:41
 */
public class BooleanExpression implements Expression<Boolean> {
    private boolean value;

    public BooleanExpression(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean eval(Map contextValues) {
        return value;
    }
}
