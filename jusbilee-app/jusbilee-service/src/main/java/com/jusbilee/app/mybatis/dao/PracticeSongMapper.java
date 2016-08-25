package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PracticeSongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @SelectProvider(type = PracticeSongSqlProvider.class, method = "countByExample")
    long countByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @DeleteProvider(type = PracticeSongSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Delete({
            "delete from t_practice_song",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Insert({
            "insert into t_practice_song (song_id, style_id, ",
            "lock_gold_coin, is_deleted, ",
            "create_time, update_time)",
            "values (#{songId,jdbcType=INTEGER}, #{styleId,jdbcType=INTEGER}, ",
            "#{lockGoldCoin,jdbcType=INTEGER}, #{isDeleted,jdbcType=TINYINT}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @InsertProvider(type = PracticeSongSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @SelectProvider(type = PracticeSongSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "style_id", property = "styleId", jdbcType = JdbcType.INTEGER),
            @Result(column = "lock_gold_coin", property = "lockGoldCoin", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<PracticeSong> selectByExample(PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Select({
            "select",
            "id, song_id, style_id, lock_gold_coin, is_deleted, create_time, update_time",
            "from t_practice_song",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "song_id", property = "songId", jdbcType = JdbcType.INTEGER),
            @Result(column = "style_id", property = "styleId", jdbcType = JdbcType.INTEGER),
            @Result(column = "lock_gold_coin", property = "lockGoldCoin", jdbcType = JdbcType.INTEGER),
            @Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    PracticeSong selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = PracticeSongSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PracticeSong record, @Param("example") PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = PracticeSongSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PracticeSong record, @Param("example") PracticeSongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @UpdateProvider(type = PracticeSongSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PracticeSong record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_practice_song
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    @Update({
            "update t_practice_song",
            "set song_id = #{songId,jdbcType=INTEGER},",
            "style_id = #{styleId,jdbcType=INTEGER},",
            "lock_gold_coin = #{lockGoldCoin,jdbcType=INTEGER},",
            "is_deleted = #{isDeleted,jdbcType=TINYINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PracticeSong record);
}