package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.RaceSeasonSong;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSongCriteria;
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

public interface RaceSeasonSongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=RaceSeasonSongSqlProvider.class, method="countByExample")
    long countByExample(RaceSeasonSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @DeleteProvider(type=RaceSeasonSongSqlProvider.class, method="deleteByExample")
    int deleteByExample(RaceSeasonSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Delete({
        "delete from t_race_season_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Insert({
        "insert into t_race_season_song (season_id, song_id, ",
        "level_id, sub_level_id, ",
        "is_deleted, create_time, ",
        "update_time)",
        "values (#{seasonId,jdbcType=INTEGER}, #{songId,jdbcType=INTEGER}, ",
        "#{levelId,jdbcType=INTEGER}, #{subLevelId,jdbcType=INTEGER}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RaceSeasonSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @InsertProvider(type=RaceSeasonSongSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RaceSeasonSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=RaceSeasonSongSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="season_id", property="seasonId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="sub_level_id", property="subLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RaceSeasonSong> selectByExample(RaceSeasonSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Select({
        "select",
        "id, season_id, song_id, level_id, sub_level_id, is_deleted, create_time, update_time",
        "from t_race_season_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="season_id", property="seasonId", jdbcType=JdbcType.INTEGER),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="sub_level_id", property="subLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RaceSeasonSong selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=RaceSeasonSongSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RaceSeasonSong record, @Param("example") RaceSeasonSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=RaceSeasonSongSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RaceSeasonSong record, @Param("example") RaceSeasonSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=RaceSeasonSongSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RaceSeasonSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_race_season_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Update({
        "update t_race_season_song",
        "set season_id = #{seasonId,jdbcType=INTEGER},",
          "song_id = #{songId,jdbcType=INTEGER},",
          "level_id = #{levelId,jdbcType=INTEGER},",
          "sub_level_id = #{subLevelId,jdbcType=INTEGER},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RaceSeasonSong record);
}