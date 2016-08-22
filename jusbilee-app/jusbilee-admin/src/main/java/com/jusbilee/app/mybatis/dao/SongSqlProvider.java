package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongCriteria.Criteria;
import com.jusbilee.app.mybatis.pojo.SongCriteria.Criterion;
import com.jusbilee.app.mybatis.pojo.SongCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SongSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String countByExample(SongCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_song");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String deleteByExample(SongCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_song");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String insertSelective(Song record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_song");

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null) {
            sql.VALUES("cover_url", "#{coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getOpernUrl() != null) {
            sql.VALUES("opern_url", "#{opernUrl,jdbcType=VARCHAR}");
        }

        if (record.getPlayUrl() != null) {
            sql.VALUES("play_url", "#{playUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String selectByExample(SongCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("description");
        sql.SELECT("cover_url");
        sql.SELECT("opern_url");
        sql.SELECT("play_url");
        sql.SELECT("is_deleted");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_song");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        if (example.getLimit() != null && example.getOffset() != null) {
            StringBuilder buf = new StringBuilder(128);
            sql.usingAppender(buf);
            buf.append("limit ");
            buf.append(example.getOffset());
            buf.append(", ");
            buf.append(example.getLimit());
            return buf.toString();
        }
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Song record = (Song) parameter.get("record");
        SongCriteria example = (SongCriteria) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_song");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null) {
            sql.SET("cover_url = #{record.coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getOpernUrl() != null) {
            sql.SET("opern_url = #{record.opernUrl,jdbcType=VARCHAR}");
        }

        if (record.getPlayUrl() != null) {
            sql.SET("play_url = #{record.playUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_song");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("cover_url = #{record.coverUrl,jdbcType=VARCHAR}");
        sql.SET("opern_url = #{record.opernUrl,jdbcType=VARCHAR}");
        sql.SET("play_url = #{record.playUrl,jdbcType=VARCHAR}");
        sql.SET("is_deleted = #{record.isDeleted,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");

        SongCriteria example = (SongCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    public String updateByPrimaryKeySelective(Song record) {
        SQL sql = new SQL();
        sql.UPDATE("t_song");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null) {
            sql.SET("cover_url = #{coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getOpernUrl() != null) {
            sql.SET("opern_url = #{opernUrl,jdbcType=VARCHAR}");
        }

        if (record.getPlayUrl() != null) {
            sql.SET("play_url = #{playUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Mon Aug 22 00:18:23 CST 2016
     */
    protected void applyWhere(SQL sql, SongCriteria example, boolean includeExamplePhrase) {
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