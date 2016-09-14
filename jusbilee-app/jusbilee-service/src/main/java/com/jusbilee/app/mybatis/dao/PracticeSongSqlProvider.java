package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria.Criterion;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PracticeSongSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String countByExample(PracticeSongCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_practice_song");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String deleteByExample(PracticeSongCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_practice_song");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String insertSelective(PracticeSong record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_practice_song");
        
        if (record.getSongId() != null) {
            sql.VALUES("song_id", "#{songId,jdbcType=INTEGER}");
        }
        
        if (record.getStyleId() != null) {
            sql.VALUES("style_id", "#{styleId,jdbcType=INTEGER}");
        }
        
        if (record.getUnlockGoldCoin() != null) {
            sql.VALUES("unlock_gold_coin", "#{unlockGoldCoin,jdbcType=INTEGER}");
        }
        
        if (record.getPassStageUnlock() != null) {
            sql.VALUES("pass_stage_unlock", "#{passStageUnlock,jdbcType=TINYINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
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
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String selectByExample(PracticeSongCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("song_id");
        sql.SELECT("style_id");
        sql.SELECT("unlock_gold_coin");
        sql.SELECT("pass_stage_unlock");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_practice_song");
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
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PracticeSong record = (PracticeSong) parameter.get("record");
        PracticeSongCriteria example = (PracticeSongCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_practice_song");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getSongId() != null) {
            sql.SET("song_id = #{record.songId,jdbcType=INTEGER}");
        }
        
        if (record.getStyleId() != null) {
            sql.SET("style_id = #{record.styleId,jdbcType=INTEGER}");
        }
        
        if (record.getUnlockGoldCoin() != null) {
            sql.SET("unlock_gold_coin = #{record.unlockGoldCoin,jdbcType=INTEGER}");
        }
        
        if (record.getPassStageUnlock() != null) {
            sql.SET("pass_stage_unlock = #{record.passStageUnlock,jdbcType=TINYINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
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
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_practice_song");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("song_id = #{record.songId,jdbcType=INTEGER}");
        sql.SET("style_id = #{record.styleId,jdbcType=INTEGER}");
        sql.SET("unlock_gold_coin = #{record.unlockGoldCoin,jdbcType=INTEGER}");
        sql.SET("pass_stage_unlock = #{record.passStageUnlock,jdbcType=TINYINT}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        PracticeSongCriteria example = (PracticeSongCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String updateByPrimaryKeySelective(PracticeSong record) {
        SQL sql = new SQL();
        sql.UPDATE("t_practice_song");
        
        if (record.getSongId() != null) {
            sql.SET("song_id = #{songId,jdbcType=INTEGER}");
        }
        
        if (record.getStyleId() != null) {
            sql.SET("style_id = #{styleId,jdbcType=INTEGER}");
        }
        
        if (record.getUnlockGoldCoin() != null) {
            sql.SET("unlock_gold_coin = #{unlockGoldCoin,jdbcType=INTEGER}");
        }
        
        if (record.getPassStageUnlock() != null) {
            sql.SET("pass_stage_unlock = #{passStageUnlock,jdbcType=TINYINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
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
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    protected void applyWhere(SQL sql, PracticeSongCriteria example, boolean includeExamplePhrase) {
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