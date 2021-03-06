package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.SongSubLevel;
import com.jusbilee.app.mybatis.pojo.SongSubLevelCriteria;
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

public interface SongSubLevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=SongSubLevelSqlProvider.class, method="countByExample")
    long countByExample(SongSubLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @DeleteProvider(type=SongSubLevelSqlProvider.class, method="deleteByExample")
    int deleteByExample(SongSubLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Delete({
        "delete from t_song_sub_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Insert({
        "insert into t_song_sub_level (sub_level_name, level_id, ",
        "score, is_deleted, ",
        "create_time, update_time)",
        "values (#{subLevelName,jdbcType=VARCHAR}, #{levelId,jdbcType=INTEGER}, ",
        "#{score,jdbcType=INTEGER}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SongSubLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @InsertProvider(type=SongSubLevelSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SongSubLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @SelectProvider(type=SongSubLevelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sub_level_name", property="subLevelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SongSubLevel> selectByExample(SongSubLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Select({
        "select",
        "id, sub_level_name, level_id, score, is_deleted, create_time, update_time",
        "from t_song_sub_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sub_level_name", property="subLevelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SongSubLevel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSubLevelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SongSubLevel record, @Param("example") SongSubLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSubLevelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SongSubLevel record, @Param("example") SongSubLevelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @UpdateProvider(type=SongSubLevelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SongSubLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_sub_level
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    @Update({
        "update t_song_sub_level",
        "set sub_level_name = #{subLevelName,jdbcType=VARCHAR},",
          "level_id = #{levelId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=INTEGER},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SongSubLevel record);
}