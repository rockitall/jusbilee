package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserPracticeActLog;
import com.jusbilee.app.mybatis.pojo.UserPracticeActLogCriteria;
import com.jusbilee.app.mybatis.pojo.UserPracticeActLogCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.UserPracticeActLogCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class UserPracticeActLogSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String countByExample(UserPracticeActLogCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_practice_act_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String deleteByExample(UserPracticeActLogCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_practice_act_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String insertSelective(UserPracticeActLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_practice_act_log");

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getPracticeSongId() != null) {
            sql.VALUES("practice_song_id", "#{practiceSongId,jdbcType=INTEGER}");
        }

        if (record.getStyleId() != null) {
            sql.VALUES("style_id", "#{styleId,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeTime() != null) {
            sql.VALUES("total_practice_time", "#{totalPracticeTime,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeCount() != null) {
            sql.VALUES("total_practice_count", "#{totalPracticeCount,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeScore() != null) {
            sql.VALUES("total_practice_score", "#{totalPracticeScore,jdbcType=INTEGER}");
        }

        if (record.getBestAvgScore() != null) {
            sql.VALUES("best_avg_score", "#{bestAvgScore,jdbcType=INTEGER}");
        }

        if (record.getFullScoreBestTime() != null) {
            sql.VALUES("full_score_best_time", "#{fullScoreBestTime,jdbcType=INTEGER}");
        }

        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String selectByExample(UserPracticeActLogCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("practice_song_id");
        sql.SELECT("style_id");
        sql.SELECT("total_practice_time");
        sql.SELECT("total_practice_count");
        sql.SELECT("total_practice_score");
        sql.SELECT("best_avg_score");
        sql.SELECT("full_score_best_time");
        sql.SELECT("is_deleted");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_user_practice_act_log");
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
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserPracticeActLog record = (UserPracticeActLog) parameter.get("record");
        UserPracticeActLogCriteria example = (UserPracticeActLogCriteria) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_user_practice_act_log");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }

        if (record.getPracticeSongId() != null) {
            sql.SET("practice_song_id = #{record.practiceSongId,jdbcType=INTEGER}");
        }

        if (record.getStyleId() != null) {
            sql.SET("style_id = #{record.styleId,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeTime() != null) {
            sql.SET("total_practice_time = #{record.totalPracticeTime,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeCount() != null) {
            sql.SET("total_practice_count = #{record.totalPracticeCount,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeScore() != null) {
            sql.SET("total_practice_score = #{record.totalPracticeScore,jdbcType=INTEGER}");
        }

        if (record.getBestAvgScore() != null) {
            sql.SET("best_avg_score = #{record.bestAvgScore,jdbcType=INTEGER}");
        }

        if (record.getFullScoreBestTime() != null) {
            sql.SET("full_score_best_time = #{record.fullScoreBestTime,jdbcType=INTEGER}");
        }

        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{record.isDeleted,jdbcType=TINYINT}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_practice_act_log");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("practice_song_id = #{record.practiceSongId,jdbcType=INTEGER}");
        sql.SET("style_id = #{record.styleId,jdbcType=INTEGER}");
        sql.SET("total_practice_time = #{record.totalPracticeTime,jdbcType=INTEGER}");
        sql.SET("total_practice_count = #{record.totalPracticeCount,jdbcType=INTEGER}");
        sql.SET("total_practice_score = #{record.totalPracticeScore,jdbcType=INTEGER}");
        sql.SET("best_avg_score = #{record.bestAvgScore,jdbcType=INTEGER}");
        sql.SET("full_score_best_time = #{record.fullScoreBestTime,jdbcType=INTEGER}");
        sql.SET("is_deleted = #{record.isDeleted,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");

        UserPracticeActLogCriteria example = (UserPracticeActLogCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String updateByPrimaryKeySelective(UserPracticeActLog record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_practice_act_log");

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getPracticeSongId() != null) {
            sql.SET("practice_song_id = #{practiceSongId,jdbcType=INTEGER}");
        }

        if (record.getStyleId() != null) {
            sql.SET("style_id = #{styleId,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeTime() != null) {
            sql.SET("total_practice_time = #{totalPracticeTime,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeCount() != null) {
            sql.SET("total_practice_count = #{totalPracticeCount,jdbcType=INTEGER}");
        }

        if (record.getTotalPracticeScore() != null) {
            sql.SET("total_practice_score = #{totalPracticeScore,jdbcType=INTEGER}");
        }

        if (record.getBestAvgScore() != null) {
            sql.SET("best_avg_score = #{bestAvgScore,jdbcType=INTEGER}");
        }

        if (record.getFullScoreBestTime() != null) {
            sql.SET("full_score_best_time = #{fullScoreBestTime,jdbcType=INTEGER}");
        }

        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_practice_act_log
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    protected void applyWhere(SQL sql, UserPracticeActLogCriteria example, boolean includeExamplePhrase) {
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