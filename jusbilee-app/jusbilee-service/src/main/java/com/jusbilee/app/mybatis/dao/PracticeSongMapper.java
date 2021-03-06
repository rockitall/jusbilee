package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria;
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

public interface PracticeSongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=PracticeSongSqlProvider.class, method="countByExample")
    long countByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @DeleteProvider(type=PracticeSongSqlProvider.class, method="deleteByExample")
    int deleteByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Delete({
        "delete from t_practice_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Insert({
        "insert into t_practice_song (song_id, style_id, ",
        "unlock_gold_coin, pass_stage_unlock, ",
        "start_time, end_time, ",
        "status, create_time, ",
        "update_time)",
        "values (#{songId,jdbcType=INTEGER}, #{styleId,jdbcType=INTEGER}, ",
        "#{unlockGoldCoin,jdbcType=INTEGER}, #{passStageUnlock,jdbcType=TINYINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @InsertProvider(type=PracticeSongSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=PracticeSongSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="style_id", property="styleId", jdbcType=JdbcType.INTEGER),
        @Result(column="unlock_gold_coin", property="unlockGoldCoin", jdbcType=JdbcType.INTEGER),
        @Result(column="pass_stage_unlock", property="passStageUnlock", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PracticeSong> selectByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Select({
        "select",
        "id, song_id, style_id, unlock_gold_coin, pass_stage_unlock, start_time, end_time, ",
        "status, create_time, update_time",
        "from t_practice_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="song_id", property="songId", jdbcType=JdbcType.INTEGER),
        @Result(column="style_id", property="styleId", jdbcType=JdbcType.INTEGER),
        @Result(column="unlock_gold_coin", property="unlockGoldCoin", jdbcType=JdbcType.INTEGER),
        @Result(column="pass_stage_unlock", property="passStageUnlock", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PracticeSong selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=PracticeSongSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PracticeSong record, @Param("example") PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=PracticeSongSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PracticeSong record, @Param("example") PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=PracticeSongSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Update({
        "update t_practice_song",
        "set song_id = #{songId,jdbcType=INTEGER},",
          "style_id = #{styleId,jdbcType=INTEGER},",
          "unlock_gold_coin = #{unlockGoldCoin,jdbcType=INTEGER},",
          "pass_stage_unlock = #{passStageUnlock,jdbcType=TINYINT},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PracticeSong record);
}