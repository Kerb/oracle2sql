package net.kerba.oracle2sql.config;

import net.kerba.oracle2sql.expression.DummyExpression;
import net.kerba.oracle2sql.expression.Expression;

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
        return new DummyExpression(config.get(param.getKey()));
    }
}
