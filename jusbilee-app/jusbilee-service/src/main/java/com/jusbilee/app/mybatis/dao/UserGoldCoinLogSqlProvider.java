package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserGoldCoinLog;
import com.jusbilee.app.mybatis.pojo.UserGoldCoinLogCriteria;
import com.jusbilee.app.mybatis.pojo.UserGoldCoinLogCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.UserGoldCoinLogCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class UserGoldCoinLogSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String countByExample(UserGoldCoinLogCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_gold_coin_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String deleteByExample(UserGoldCoinLogCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_gold_coin_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String insertSelective(UserGoldCoinLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_gold_coin_log");

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }

        if (record.getGoldCoin() != null) {
            sql.VALUES("gold_coin", "#{goldCoin,jdbcType=INTEGER}");
        }

        if (record.getEventId() != null) {
            sql.VALUES("event_id", "#{eventId,jdbcType=INTEGER}");
        }

        if (record.getEventName() != null) {
            sql.VALUES("event_name", "#{eventName,jdbcType=VARCHAR}");
        }

        if (record.getEventTargetId() != null) {
            sql.VALUES("event_target_id", "#{eventTargetId,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String selectByExample(UserGoldCoinLogCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("type");
        sql.SELECT("gold_coin");
        sql.SELECT("event_id");
        sql.SELECT("event_name");
        sql.SELECT("event_target_id");
        sql.SELECT("create_time");
        sql.FROM("t_user_gold_coin_log");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        if (example.getLimit() != null && example.getOffset() != null) {
            StringBuilder buf = new StringBuilder(128);
            sql.usingAppender(buf);
            buf.append(" limit ");
            buf.append(example.getOffset());
            buf.append(", ");
            buf.append(example.getLimit());
            return buf.toString();
        }
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserGoldCoinLog record = (UserGoldCoinLog) parameter.get("record");
        UserGoldCoinLogCriteria example = (UserGoldCoinLogCriteria) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_user_gold_coin_log");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }

        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }

        if (record.getGoldCoin() != null) {
            sql.SET("gold_coin = #{record.goldCoin,jdbcType=INTEGER}");
        }

        if (record.getEventId() != null) {
            sql.SET("event_id = #{record.eventId,jdbcType=INTEGER}");
        }

        if (record.getEventName() != null) {
            sql.SET("event_name = #{record.eventName,jdbcType=VARCHAR}");
        }

        if (record.getEventTargetId() != null) {
            sql.SET("event_target_id = #{record.eventTargetId,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_gold_coin_log");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("gold_coin = #{record.goldCoin,jdbcType=INTEGER}");
        sql.SET("event_id = #{record.eventId,jdbcType=INTEGER}");
        sql.SET("event_name = #{record.eventName,jdbcType=VARCHAR}");
        sql.SET("event_target_id = #{record.eventTargetId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");

        UserGoldCoinLogCriteria example = (UserGoldCoinLogCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String updateByPrimaryKeySelective(UserGoldCoinLog record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_gold_coin_log");

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }

        if (record.getGoldCoin() != null) {
            sql.SET("gold_coin = #{goldCoin,jdbcType=INTEGER}");
        }

        if (record.getEventId() != null) {
            sql.SET("event_id = #{eventId,jdbcType=INTEGER}");
        }

        if (record.getEventName() != null) {
            sql.SET("event_name = #{eventName,jdbcType=VARCHAR}");
        }

        if (record.getEventTargetId() != null) {
            sql.SET("event_target_id = #{eventTargetId,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_gold_coin_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    protected void applyWhere(SQL sql, UserGoldCoinLogCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}