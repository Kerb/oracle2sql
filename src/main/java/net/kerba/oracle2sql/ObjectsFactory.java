package net.kerba.oracle2sql;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.FunctionMapper;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 21:46
 */
public class ObjectsFactory {
    private static ExpressionFactory expressionFactory = new ExpressionFactoryImpl();

    private ObjectsFactory() {}

    public static ExpressionFactory getExpressionFactory() {
        return expressionFactory;
    }

    public static SimpleContext createContext() {

        SimpleContext context = new SimpleContext();
        try {
            context.setFunction("f", "contains", Functions.class.getMethod("contains", String.class, String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return context;
    }

    public static class Functions {
        private Functions() {}

        public static boolean contains(String s1, String s2) {
            return s1.contains(s2);
        }
    }
}
