package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserStageLog;
import com.jusbilee.app.mybatis.pojo.UserStageLogCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserStageLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @SelectProvider(type = UserStageLogSqlProvider.class, method = "countByExample")
    long countByExample(UserStageLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @DeleteProvider(type = UserStageLogSqlProvider.class, method = "deleteByExample")
    int deleteByExample(UserStageLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Delete({
            "delete from t_user_stage_log",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Insert({
            "insert into t_user_stage_log (user_id, song_id, ",
            "stage_song_id, stage_level_id, ",
            "is_assist, assist_user_id, ",
            "score, is_passed, ",
            "create_time)",
            "values (#{userId,jdbcType=BIGINT}, #{songId,jdbcType=INTEGER}, ",
            "#{stageSongId,jdbcType=INTEGER}, #{stageLevelId,jdbcType=INTEGER}, ",
            "#{isAssist,jdbcType=TINYINT}, #{assistUserId,jdbcType=BIGINT}, ",
            "#{score,jdbcType=INTEGER}, #{isPassed,jdbcType=TINYINT}, ",
            "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(UserStageLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @InsertProvider(type = UserStageLogSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(UserStageLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @SelectProvider(type = UserStageLogSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_song_id", property = "stageSongId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_level_id", property = "stageLevelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_assist", property = "isAssist", jdbcType = JdbcType.TINYINT),
            @Result(column = "assist_user_id", property = "assistUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_passed", property = "isPassed", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<UserStageLog> selectByExample(UserStageLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Select({
            "select",
            "id, user_id, song_id, stage_song_id, stage_level_id, is_assist, assist_user_id, ",
            "score, is_passed, create_time",
            "from t_user_stage_log",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_song_id", property = "stageSongId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_level_id", property = "stageLevelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_assist", property = "isAssist", jdbcType = JdbcType.TINYINT),
            @Result(column = "assist_user_id", property = "assistUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_passed", property = "isPassed", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    UserStageLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageLogSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserStageLog record, @Param("example") UserStageLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageLogSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") UserStageLog record, @Param("example") UserStageLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageLogSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserStageLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_log
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Update({
            "update t_user_stage_log",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "song_id = #{songId,jdbcType=INTEGER},",
            "stage_song_id = #{stageSongId,jdbcType=INTEGER},",
            "stage_level_id = #{stageLevelId,jdbcType=INTEGER},",
            "is_assist = #{isAssist,jdbcType=TINYINT},",
            "assist_user_id = #{assistUserId,jdbcType=BIGINT},",
            "score = #{score,jdbcType=INTEGER},",
            "is_passed = #{isPassed,jdbcType=TINYINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserStageLog record);
}