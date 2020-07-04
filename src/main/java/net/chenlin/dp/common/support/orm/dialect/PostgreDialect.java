package net.chenlin.dp.common.support.orm.dialect;

/**
 * Postgre 数据库 方言
 * @author zhouchenglin[yczclcn@163.com]
 */
public class PostgreDialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        sql = getLineSql(sql);
        return (sql + " LIMIT " + limit + " OFFSET " + offset);
    }

}
