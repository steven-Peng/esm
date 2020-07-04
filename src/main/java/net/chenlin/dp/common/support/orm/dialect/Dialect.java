package net.chenlin.dp.common.support.orm.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据库方言抽象类
 * @author zhouchenglin[yczclcn@163.com]
 */
public abstract class Dialect {

    /**
     * 得到分页sql
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public abstract String getLimitString(String sql, int offset, int limit);

    /**
     * 得到分页sql
     * @param sql
     * @return
     */
    public String getCountString(String sql) {
        sql = getLineSql(sql);
        int orderIndex = getLastOrderInsertPoint(sql);

        int formIndex = getAfterFormInsertPoint(sql);
        String select = sql.substring(0, formIndex);

        // 如果SELECT 中包含 DISTINCT 只能在外层包含COUNT
        if (select.toLowerCase().indexOf("select distinct") != -1 || sql.toLowerCase().indexOf("group by") != -1) {
            return new StringBuffer(sql.length()).append("select count(1) count from (").append(sql.substring(0, orderIndex)).append(" ) t").toString();
        } else {
            return new StringBuffer(sql.length()).append("select count(1) count ").append(sql.substring(formIndex, orderIndex)).toString();
        }
    }

    /**
     * 得到最后一个Order By的插入点位置
     *
     * @return 返回最后一个Order By插入点的位置
     */
    protected int getLastOrderInsertPoint(String querySelect) {
        int orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
        if (orderIndex == -1) {
            orderIndex = querySelect.length();
        }
        if (!isBracketCanPartnership(querySelect.substring(orderIndex, querySelect.length()))) {
            throw new RuntimeException("My SQL 分页必须要有Order by 语句!");
        }
        return orderIndex;
    }

    /**
     * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
     *
     * @param sql
     *            SQL语句
     * @return 如果sql是NULL返回空，否则返回转化后的SQL
     */
    protected String getLineSql(String sql) {
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
    }

    /**
     * 得到SQL第一个正确的FROM的的插入点
     */
    protected int getAfterFormInsertPoint(String querySelect) {
        String regex = "\\s+FROM\\s+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(querySelect);
        while (matcher.find()) {
            int fromStartIndex = matcher.start(0);
            String text = querySelect.substring(0, fromStartIndex);
            if (isBracketCanPartnership(text)) {
                return fromStartIndex;
            }
        }
        return 0;
    }

    /**
     * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
     *
     * @param text
     *            要判断的文本
     * @return 如果匹配返回TRUE,否则返回FALSE
     */
    protected boolean isBracketCanPartnership(String text) {
        if (text == null || (getIndexOfCount(text, '(') != getIndexOfCount(text, ')'))) {
            return false;
        }
        return true;
    }

    /**
     * 得到一个字符在另一个字符串中出现的次数
     *
     * @param text
     *            文本
     * @param ch
     *            字符
     */
    protected int getIndexOfCount(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            count = (text.charAt(i) == ch) ? count + 1 : count;
        }
        return count;
    }

}
