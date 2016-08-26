package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.StageLevel;
import com.jusbilee.app.mybatis.pojo.StageLevelCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StageLevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @SelectProvider(type = StageLevelSqlProvider.class, method = "countByExample")
    long countByExample(StageLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @DeleteProvider(type = StageLevelSqlProvider.class, method = "deleteByExample")
    int deleteByExample(StageLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Delete({
            "delete from t_stage_level",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Insert({
            "insert into t_stage_level (name, weight, ",
            "song_count, is_deleted, ",
            "create_time, update_time)",
            "values (#{name,jdbcType=VARCHAR}, #{weight,jdbcType=INTEGER}, ",
            "#{songCount,jdbcType=INTEGER}, #{isDeleted,jdbcType=TINYINT}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(StageLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @InsertProvider(type = StageLevelSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(StageLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @SelectProvider(type = StageLevelSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "weight", property = "weight", jdbcType = JdbcType.INTEGER),
            @Result(column = "song_count", property = "songCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<StageLevel> selectByExample(StageLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Select({
            "select",
            "id, name, weight, song_count, is_deleted, create_time, update_time",
            "from t_stage_level",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "weight", property = "weight", jdbcType = JdbcType.INTEGER),
            @Result(column = "song_count", property = "songCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    StageLevel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = StageLevelSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StageLevel record, @Param("example") StageLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = StageLevelSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") StageLevel record, @Param("example") StageLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = StageLevelSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StageLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stage_level
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Update({
            "update t_stage_level",
            "set name = #{name,jdbcType=VARCHAR},",
            "weight = #{weight,jdbcType=INTEGER},",
            "song_count = #{songCount,jdbcType=INTEGER},",
            "is_deleted = #{isDeleted,jdbcType=TINYINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StageLevel record);
}