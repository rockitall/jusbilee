package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserStageActLog;
import com.jusbilee.app.mybatis.pojo.UserStageActLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserStageActLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=UserStageActLogSqlProvider.class, method="countByExample")
    long countByExample(UserStageActLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @DeleteProvider(type=UserStageActLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserStageActLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Delete({
        "delete from t_user_stage_act_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Insert({
        "insert into t_user_stage_act_log (user_id, stage_song_id, ",
        "stage_level_id, is_assist, ",
        "assist_user_id, score, ",
        "is_passed, act_count, ",
        "is_deleted, create_time, ",
        "update_time)",
        "values (#{userId,jdbcType=BIGINT}, #{stageSongId,jdbcType=INTEGER}, ",
        "#{stageLevelId,jdbcType=INTEGER}, #{isAssist,jdbcType=TINYINT}, ",
        "#{assistUserId,jdbcType=BIGINT}, #{score,jdbcType=INTEGER}, ",
        "#{isPassed,jdbcType=TINYINT}, #{actCount,jdbcType=INTEGER}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserStageActLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @InsertProvider(type=UserStageActLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserStageActLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=UserStageActLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="stage_song_id", property="stageSongId", jdbcType=JdbcType.INTEGER),
        @Result(column="stage_level_id", property="stageLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_assist", property="isAssist", jdbcType=JdbcType.TINYINT),
        @Result(column="assist_user_id", property="assistUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="is_passed", property="isPassed", jdbcType=JdbcType.TINYINT),
        @Result(column="act_count", property="actCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserStageActLog> selectByExample(UserStageActLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Select({
        "select",
        "id, user_id, stage_song_id, stage_level_id, is_assist, assist_user_id, score, ",
        "is_passed, act_count, is_deleted, create_time, update_time",
        "from t_user_stage_act_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="stage_song_id", property="stageSongId", jdbcType=JdbcType.INTEGER),
        @Result(column="stage_level_id", property="stageLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_assist", property="isAssist", jdbcType=JdbcType.TINYINT),
        @Result(column="assist_user_id", property="assistUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="is_passed", property="isPassed", jdbcType=JdbcType.TINYINT),
        @Result(column="act_count", property="actCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserStageActLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserStageActLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserStageActLog record, @Param("example") UserStageActLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserStageActLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserStageActLog record, @Param("example") UserStageActLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserStageActLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserStageActLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_stage_act_log
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Update({
        "update t_user_stage_act_log",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "stage_song_id = #{stageSongId,jdbcType=INTEGER},",
          "stage_level_id = #{stageLevelId,jdbcType=INTEGER},",
          "is_assist = #{isAssist,jdbcType=TINYINT},",
          "assist_user_id = #{assistUserId,jdbcType=BIGINT},",
          "score = #{score,jdbcType=INTEGER},",
          "is_passed = #{isPassed,jdbcType=TINYINT},",
          "act_count = #{actCount,jdbcType=INTEGER},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserStageActLog record);
}