package net.kerba.oracle2sql.expression;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 19:54
 */
public class DummyExpression implements Expression {
    private Object value;

    public DummyExpression(Object value) {
        this.value = value;
    }

    @Override
    public Object eval() {
        return value;
    }
}
