package net.kerba.oracle2sql.config;

import net.kerba.oracle2sql.ObjectsFactory;
import net.kerba.oracle2sql.expression.ConstantValueExpression;
import net.kerba.oracle2sql.expression.Expression;
import net.kerba.utils.Check;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 19:32
 */
public class DefaultConfiguration implements Configuration {
    private Properties config;

    public DefaultConfiguration() {
        config = new Properties();
        try {
            config.load(this.getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration from file");
        }
    }

    @Override
    public Expression getParameter(Param param) {
        return new ConstantValueExpression(config.get(param.getKey()));
    }

    public static Facade facade() {
        final Configuration config = new DefaultConfiguration();

        return new Facade() {
            @Override
            public boolean getBoolean(Param param) {
                return config.getParameter(param).eval(ObjectsFactory.EMPTY_CONTEXT_VALUES,Boolean.class);
            }

            @Override
            public String getString(Param param) {
                return config.getParameter(param).eval(ObjectsFactory.EMPTY_CONTEXT_VALUES,String.class);
            }
        };
    }
}
