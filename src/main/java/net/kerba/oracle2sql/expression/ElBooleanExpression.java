package net.kerba.oracle2sql.expression;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import net.kerba.oracle2sql.ObjectsFactory;
import net.kerba.utils.Check;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 21:21
 */
public class ElBooleanExpression implements Expression<Boolean> {
    private String expression;

    public ElBooleanExpression(String expression) {
        Check.notNull(expression, "expression");

        this.expression = expression;
    }

    @Override
    public Boolean eval(Map contextValues) {
        Check.notNull(contextValues, "contextValues");

        SimpleContext context = ObjectsFactory.createContext();

        context.setVariable("object", ObjectsFactory
                                        .getExpressionFactory()
                                        .createValueExpression(contextValues, Map.class));

        ValueExpression valueExpression = ObjectsFactory
                                            .getExpressionFactory()
                                            .createValueExpression(context, expression, Boolean.class);
        return (Boolean)valueExpression.getValue(context);
    }
}
