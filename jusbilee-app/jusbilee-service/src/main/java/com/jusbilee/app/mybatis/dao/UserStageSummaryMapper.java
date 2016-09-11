package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserStageSummary;
import com.jusbilee.app.mybatis.pojo.UserStageSummaryCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserStageSummaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @SelectProvider(type = UserStageSummarySqlProvider.class, method = "countByExample")
    long countByExample(UserStageSummaryCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @DeleteProvider(type = UserStageSummarySqlProvider.class, method = "deleteByExample")
    int deleteByExample(UserStageSummaryCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Delete({
            "delete from t_user_stage_summary",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Insert({
            "insert into t_user_stage_summary (user_id, stage_song_id, ",
            "stage_level_id, song_id, ",
            "is_assist, assist_user_id, ",
            "score, is_passed, ",
            "stage_count, create_time, ",
            "update_time)",
            "values (#{userId,jdbcType=BIGINT}, #{stageSongId,jdbcType=INTEGER}, ",
            "#{stageLevelId,jdbcType=INTEGER}, #{songId,jdbcType=INTEGER}, ",
            "#{isAssist,jdbcType=TINYINT}, #{assistUserId,jdbcType=BIGINT}, ",
            "#{score,jdbcType=INTEGER}, #{isPassed,jdbcType=TINYINT}, ",
            "#{stageCount,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(UserStageSummary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @InsertProvider(type = UserStageSummarySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(UserStageSummary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @SelectProvider(type = UserStageSummarySqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "stage_song_id", property = "stageSongId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_level_id", property = "stageLevelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_assist", property = "isAssist", jdbcType = JdbcType.TINYINT),
            @Result(column = "assist_user_id", property = "assistUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_passed", property = "isPassed", jdbcType = JdbcType.TINYINT),
            @Result(column = "stage_count", property = "stageCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<UserStageSummary> selectByExample(UserStageSummaryCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Select({
            "select",
            "id, user_id, stage_song_id, stage_level_id, song_id, is_assist, assist_user_id, ",
            "score, is_passed, stage_count, create_time, update_time",
            "from t_user_stage_summary",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "stage_song_id", property = "stageSongId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stage_level_id", property = "stageLevelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_assist", property = "isAssist", jdbcType = JdbcType.TINYINT),
            @Result(column = "assist_user_id", property = "assistUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_passed", property = "isPassed", jdbcType = JdbcType.TINYINT),
            @Result(column = "stage_count", property = "stageCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    UserStageSummary selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageSummarySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserStageSummary record, @Param("example") UserStageSummaryCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageSummarySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") UserStageSummary record, @Param("example") UserStageSummaryCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @UpdateProvider(type = UserStageSummarySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserStageSummary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_summary
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    @Update({
            "update t_user_stage_summary",
            "set user_id = #{userId,jdbcType=BIGINT},",
            "stage_song_id = #{stageSongId,jdbcType=INTEGER},",
            "stage_level_id = #{stageLevelId,jdbcType=INTEGER},",
            "song_id = #{songId,jdbcType=INTEGER},",
            "is_assist = #{isAssist,jdbcType=TINYINT},",
            "assist_user_id = #{assistUserId,jdbcType=BIGINT},",
            "score = #{score,jdbcType=INTEGER},",
            "is_passed = #{isPassed,jdbcType=TINYINT},",
            "stage_count = #{stageCount,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserStageSummary record);
}