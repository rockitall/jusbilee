package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummary;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummaryCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummaryCriteria.Criterion;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummaryCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSeasonRaceSummarySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String countByExample(UserSeasonRaceSummaryCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_season_race_summary");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String deleteByExample(UserSeasonRaceSummaryCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_season_race_summary");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String insertSelective(UserSeasonRaceSummary record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_season_race_summary");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getSeasonId() != null) {
            sql.VALUES("season_id", "#{seasonId,jdbcType=INTEGER}");
        }
        
        if (record.getWin() != null) {
            sql.VALUES("win", "#{win,jdbcType=INTEGER}");
        }
        
        if (record.getLoss() != null) {
            sql.VALUES("loss", "#{loss,jdbcType=INTEGER}");
        }
        
        if (record.getWinStreak() != null) {
            sql.VALUES("win_streak", "#{winStreak,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getBestScore() != null) {
            sql.VALUES("best_score", "#{bestScore,jdbcType=INTEGER}");
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
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String selectByExample(UserSeasonRaceSummaryCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("season_id");
        sql.SELECT("win");
        sql.SELECT("loss");
        sql.SELECT("win_streak");
        sql.SELECT("score");
        sql.SELECT("best_score");
        sql.SELECT("is_deleted");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_user_season_race_summary");
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
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserSeasonRaceSummary record = (UserSeasonRaceSummary) parameter.get("record");
        UserSeasonRaceSummaryCriteria example = (UserSeasonRaceSummaryCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_summary");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getSeasonId() != null) {
            sql.SET("season_id = #{record.seasonId,jdbcType=INTEGER}");
        }
        
        if (record.getWin() != null) {
            sql.SET("win = #{record.win,jdbcType=INTEGER}");
        }
        
        if (record.getLoss() != null) {
            sql.SET("loss = #{record.loss,jdbcType=INTEGER}");
        }
        
        if (record.getWinStreak() != null) {
            sql.SET("win_streak = #{record.winStreak,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{record.score,jdbcType=INTEGER}");
        }
        
        if (record.getBestScore() != null) {
            sql.SET("best_score = #{record.bestScore,jdbcType=INTEGER}");
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
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_summary");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("season_id = #{record.seasonId,jdbcType=INTEGER}");
        sql.SET("win = #{record.win,jdbcType=INTEGER}");
        sql.SET("loss = #{record.loss,jdbcType=INTEGER}");
        sql.SET("win_streak = #{record.winStreak,jdbcType=INTEGER}");
        sql.SET("score = #{record.score,jdbcType=INTEGER}");
        sql.SET("best_score = #{record.bestScore,jdbcType=INTEGER}");
        sql.SET("is_deleted = #{record.isDeleted,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        UserSeasonRaceSummaryCriteria example = (UserSeasonRaceSummaryCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    public String updateByPrimaryKeySelective(UserSeasonRaceSummary record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_summary");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getSeasonId() != null) {
            sql.SET("season_id = #{seasonId,jdbcType=INTEGER}");
        }
        
        if (record.getWin() != null) {
            sql.SET("win = #{win,jdbcType=INTEGER}");
        }
        
        if (record.getLoss() != null) {
            sql.SET("loss = #{loss,jdbcType=INTEGER}");
        }
        
        if (record.getWinStreak() != null) {
            sql.SET("win_streak = #{winStreak,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getBestScore() != null) {
            sql.SET("best_score = #{bestScore,jdbcType=INTEGER}");
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
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_summary
     *
     * @mbg.generated Sat Sep 24 21:56:21 CST 2016
     */
    protected void applyWhere(SQL sql, UserSeasonRaceSummaryCriteria example, boolean includeExamplePhrase) {
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
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