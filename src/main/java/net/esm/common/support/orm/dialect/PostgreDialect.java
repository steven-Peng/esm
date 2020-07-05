package net.esm.common.support.orm.dialect;

/**
 * Postgre 数据库 方言
 *   [  ]
 */
public class PostgreDialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        sql = getLineSql(sql);
        return (sql + " LIMIT " + limit + " OFFSET " + offset);
    }

}
