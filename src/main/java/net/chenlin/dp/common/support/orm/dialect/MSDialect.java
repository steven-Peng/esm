package net.chenlin.dp.common.support.orm.dialect;

/**
 * MSSQL 数据库方言
 * @author zhouchenglin[yczclcn@163.com]
 */
public class MSDialect extends Dialect {

    @Override
    public String getLimitString(String sql, int offset, int limit) {

        sql = getLineSql(sql);
        int selectIndex = sql.toUpperCase().lastIndexOf("SELECT");
        if (selectIndex > -1) {
            sql = sql.substring(0, selectIndex) + "SELECT TOP " + (limit + offset) + sql.substring(selectIndex + 6);
        }
        return "SELECT * FROM(SELECT ROW_NUMBER () OVER (ORDER BY getdate()) rownum,* FROM( " + sql + " ) A ) B WHERE B.rownum > " + offset + " AND B.rownum <= "
                + (limit + offset);
    }

}
