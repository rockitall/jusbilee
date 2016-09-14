package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongCriteria;
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

public interface SongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=SongSqlProvider.class, method="countByExample")
    long countByExample(SongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @DeleteProvider(type=SongSqlProvider.class, method="deleteByExample")
    int deleteByExample(SongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Delete({
        "delete from t_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Insert({
        "insert into t_song (name, level_id, ",
        "style_id, description, ",
        "icon_url, opern_screenshot_url, ",
        "opern_url, wav_play_url, ",
        "midi_play_url, is_deleted, ",
        "create_time, update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{levelId,jdbcType=INTEGER}, ",
        "#{styleId,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{iconUrl,jdbcType=VARCHAR}, #{opernScreenshotUrl,jdbcType=VARCHAR}, ",
        "#{opernUrl,jdbcType=VARCHAR}, #{wavPlayUrl,jdbcType=VARCHAR}, ",
        "#{midiPlayUrl,jdbcType=VARCHAR}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @InsertProvider(type=SongSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=SongSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="style_id", property="styleId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon_url", property="iconUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="opern_screenshot_url", property="opernScreenshotUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="opern_url", property="opernUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="wav_play_url", property="wavPlayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="midi_play_url", property="midiPlayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Song> selectByExample(SongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Select({
        "select",
        "id, name, level_id, style_id, description, icon_url, opern_screenshot_url, opern_url, ",
        "wav_play_url, midi_play_url, is_deleted, create_time, update_time",
        "from t_song",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="style_id", property="styleId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon_url", property="iconUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="opern_screenshot_url", property="opernScreenshotUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="opern_url", property="opernUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="wav_play_url", property="wavPlayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="midi_play_url", property="midiPlayUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Song selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Song record, @Param("example") SongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Song record, @Param("example") SongCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Update({
        "update t_song",
        "set name = #{name,jdbcType=VARCHAR},",
          "level_id = #{levelId,jdbcType=INTEGER},",
          "style_id = #{styleId,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR},",
          "icon_url = #{iconUrl,jdbcType=VARCHAR},",
          "opern_screenshot_url = #{opernScreenshotUrl,jdbcType=VARCHAR},",
          "opern_url = #{opernUrl,jdbcType=VARCHAR},",
          "wav_play_url = #{wavPlayUrl,jdbcType=VARCHAR},",
          "midi_play_url = #{midiPlayUrl,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Song record);
}