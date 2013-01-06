package net.kerba.oracle2sql;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import net.kerba.utils.Check;

import javax.el.ExpressionFactory;
import javax.el.FunctionMapper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 21:46
 */
public class ObjectsFactory {
    public final static Map EMPTY_CONTEXT_VALUES = new HashMap();

    private static ExpressionFactory expressionFactory = new ExpressionFactoryImpl();

    private ObjectsFactory() {}

    public static ExpressionFactory getExpressionFactory() {
        return expressionFactory;
    }

    public static SimpleContext createContext() {

        SimpleContext context = new SimpleContext();

        try {
            // todo optimize: cache method list somewhere
            context.setFunction("f", "contains", ElFunctions.class.getMethod("contains", String.class, String.class));
            context.setFunction("f", "startsWith", ElFunctions.class.getMethod("startsWith", String.class, String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return context;
    }

    public static class ElFunctions {
        private ElFunctions() {}

        public static boolean contains(String sourceString, String stringToSearch) {
            if (sourceString == null) {
                sourceString = "";
            }
            if (stringToSearch == null) {
                stringToSearch = "";
            }
            return sourceString.contains(stringToSearch);
        }

        public static boolean startsWith(String sourceString, String stringToStartWith) {
            if (sourceString == null) {
                sourceString = "";
            }
            if (stringToStartWith == null) {
                stringToStartWith = "";
            }
            if (sourceString.length() < stringToStartWith.length()) {
                return false;
            }
            return sourceString.substring(0, stringToStartWith.length()).equals(stringToStartWith);

        }
    }


}
