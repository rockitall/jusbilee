package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserSeasonRaceLog;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceLogCriteria;
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

public interface UserSeasonRaceLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=UserSeasonRaceLogSqlProvider.class, method="countByExample")
    long countByExample(UserSeasonRaceLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @DeleteProvider(type=UserSeasonRaceLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserSeasonRaceLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Delete({
        "delete from t_user_season_race_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Insert({
        "insert into t_user_season_race_log (season_id, winner_user_id, ",
        "winner_score, loser_user_id, ",
        "loser_score, season_song_id, ",
        "song_id, song_level_id, ",
        "song_sub_level_id, create_time)",
        "values (#{seasonId,jdbcType=INTEGER}, #{winnerUserId,jdbcType=BIGINT}, ",
        "#{winnerScore,jdbcType=INTEGER}, #{loserUserId,jdbcType=BIGINT}, ",
        "#{loserScore,jdbcType=INTEGER}, #{seasonSongId,jdbcType=INTEGER}, ",
        "#{songId,jdbcType=INTEGER}, #{songLevelId,jdbcType=INTEGER}, ",
        "#{songSubLevelId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserSeasonRaceLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @InsertProvider(type=UserSeasonRaceLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserSeasonRaceLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=UserSeasonRaceLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="season_id", property="seasonId", jdbcType=JdbcType.INTEGER),
        @Result(column="winner_user_id", property="winnerUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="winner_score", property="winnerScore", jdbcType=JdbcType.INTEGER),
        @Result(column="loser_user_id", property="loserUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="loser_score", property="loserScore", jdbcType=JdbcType.INTEGER),
        @Result(column="season_song_id", property="seasonSongId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_level_id", property="songLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_sub_level_id", property="songSubLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserSeasonRaceLog> selectByExample(UserSeasonRaceLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Select({
        "select",
        "id, season_id, winner_user_id, winner_score, loser_user_id, loser_score, season_song_id, ",
        "song_id, song_level_id, song_sub_level_id, create_time",
        "from t_user_season_race_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="season_id", property="seasonId", jdbcType=JdbcType.INTEGER),
        @Result(column="winner_user_id", property="winnerUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="winner_score", property="winnerScore", jdbcType=JdbcType.INTEGER),
        @Result(column="loser_user_id", property="loserUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="loser_score", property="loserScore", jdbcType=JdbcType.INTEGER),
        @Result(column="season_song_id", property="seasonSongId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_level_id", property="songLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_sub_level_id", property="songSubLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserSeasonRaceLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=UserSeasonRaceLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserSeasonRaceLog record, @Param("example") UserSeasonRaceLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=UserSeasonRaceLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserSeasonRaceLog record, @Param("example") UserSeasonRaceLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=UserSeasonRaceLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSeasonRaceLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_season_race_log
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Update({
        "update t_user_season_race_log",
        "set season_id = #{seasonId,jdbcType=INTEGER},",
          "winner_user_id = #{winnerUserId,jdbcType=BIGINT},",
          "winner_score = #{winnerScore,jdbcType=INTEGER},",
          "loser_user_id = #{loserUserId,jdbcType=BIGINT},",
          "loser_score = #{loserScore,jdbcType=INTEGER},",
          "season_song_id = #{seasonSongId,jdbcType=INTEGER},",
          "song_id = #{songId,jdbcType=INTEGER},",
          "song_level_id = #{songLevelId,jdbcType=INTEGER},",
          "song_sub_level_id = #{songSubLevelId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserSeasonRaceLog record);
}