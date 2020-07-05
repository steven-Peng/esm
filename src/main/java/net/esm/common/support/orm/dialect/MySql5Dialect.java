package net.esm.common.support.orm.dialect;

/**
 * MySQL数据库方言
 *   [  ]
 */
public class MySql5Dialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        sql = getLineSql(sql);
        return (sql + " limit " + offset + " ," + limit);
    }

}
