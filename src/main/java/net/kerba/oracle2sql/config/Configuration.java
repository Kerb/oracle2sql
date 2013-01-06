package net.kerba.oracle2sql.config;

import net.kerba.oracle2sql.expression.Expression;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 05.01.13
 * Time: 19:18
 */
public interface Configuration {
    public enum Param {
        CONNECT_HOST("connect.host"),
        CONNECT_DB("connect.db"),
        CONNECT_USER("connect.user"),
        CONNECT_PASSWORD("connect.password"),
        FILTER_DEFAULT("filter.default"),
        FILTER_COLUMN("filter.column"),
        FILTER_TABLE("filter.table"),
        FILTER_COMMENT("filter.comment"),
        FILTER_CONSTRAINT_PK("filter.constraint.pk"),
        FILTER_CONSTRAINT_FK("filter.constraint.fk"),
        FILTER_CONSTRAINT_CK("filter.constraint.ck"),
        FILTER_CONSTRAINT_UN("filter.constraint.un"),
        FILTER_INDEX_NORMAL("filter.index.normal"),
        FILTER_INDEX_UNIQUE("filter.index.unique"),
        FILTER_FUNCTION("filter.function"),
        FILTER_PROCEDURE("filter.procedure"),
        FILTER_TYPE("filter.type"),
        FILTER_PACKAGE("filter.package"),
        FILTER_VIEW_NORMAL("filter.view.normal"),
        FILTER_VIEW_MATERIALIZED("filter.view.materialized"),
        FILTER_TRIGGER("filter.trigger"),
        FILTER_SEQUENCE("filter.sequence"),
        FILTER_JOB("filter.job"),
        FILTER_SCHEMA_DDL("filter.schema.ddl"),
        FILTER_SCHEMA_GRANTS("filter.schema.grants")
        ;

        private String key;

        private Param(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public Expression getParameter(Param param);

    public interface Facade {
        public boolean getBoolean(Param param);

        public String getString(Param param);

    }

}
