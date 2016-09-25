package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserSeasonRacePool;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePoolCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePoolCriteria.Criterion;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePoolCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSeasonRacePoolSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String countByExample(UserSeasonRacePoolCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_season_race_pool");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String deleteByExample(UserSeasonRacePoolCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_season_race_pool");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String insertSelective(UserSeasonRacePool record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_season_race_pool");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpponentId() != null) {
            sql.VALUES("opponent_id", "#{opponentId,jdbcType=BIGINT}");
        }
        
        if (record.getSubLevelId() != null) {
            sql.VALUES("sub_level_id", "#{subLevelId,jdbcType=INTEGER}");
        }
        
        if (record.getSeasonSongId() != null) {
            sql.VALUES("season_song_id", "#{seasonSongId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMatch() != null) {
            sql.VALUES("is_match", "#{isMatch,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String selectByExample(UserSeasonRacePoolCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("opponent_id");
        sql.SELECT("sub_level_id");
        sql.SELECT("season_song_id");
        sql.SELECT("is_match");
        sql.FROM("t_user_season_race_pool");
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
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserSeasonRacePool record = (UserSeasonRacePool) parameter.get("record");
        UserSeasonRacePoolCriteria example = (UserSeasonRacePoolCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_pool");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpponentId() != null) {
            sql.SET("opponent_id = #{record.opponentId,jdbcType=BIGINT}");
        }
        
        if (record.getSubLevelId() != null) {
            sql.SET("sub_level_id = #{record.subLevelId,jdbcType=INTEGER}");
        }
        
        if (record.getSeasonSongId() != null) {
            sql.SET("season_song_id = #{record.seasonSongId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMatch() != null) {
            sql.SET("is_match = #{record.isMatch,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_pool");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("opponent_id = #{record.opponentId,jdbcType=BIGINT}");
        sql.SET("sub_level_id = #{record.subLevelId,jdbcType=INTEGER}");
        sql.SET("season_song_id = #{record.seasonSongId,jdbcType=INTEGER}");
        sql.SET("is_match = #{record.isMatch,jdbcType=TINYINT}");
        
        UserSeasonRacePoolCriteria example = (UserSeasonRacePoolCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    public String updateByPrimaryKeySelective(UserSeasonRacePool record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_season_race_pool");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpponentId() != null) {
            sql.SET("opponent_id = #{opponentId,jdbcType=BIGINT}");
        }
        
        if (record.getSubLevelId() != null) {
            sql.SET("sub_level_id = #{subLevelId,jdbcType=INTEGER}");
        }
        
        if (record.getSeasonSongId() != null) {
            sql.SET("season_song_id = #{seasonSongId,jdbcType=INTEGER}");
        }
        
        if (record.getIsMatch() != null) {
            sql.SET("is_match = #{isMatch,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_pool
     *
     * @mbg.generated Sun Sep 25 00:34:55 CST 2016
     */
    protected void applyWhere(SQL sql, UserSeasonRacePoolCriteria example, boolean includeExamplePhrase) {
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