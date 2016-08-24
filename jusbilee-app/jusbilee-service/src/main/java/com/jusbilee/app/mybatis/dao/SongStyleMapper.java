package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.jusbilee.app.mybatis.pojo.SongStyleCriteria;
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

public interface SongStyleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @SelectProvider(type=SongStyleSqlProvider.class, method="countByExample")
    long countByExample(SongStyleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @DeleteProvider(type=SongStyleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SongStyleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @Delete({
        "delete from t_song_style",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @Insert({
        "insert into t_song_style (name, sort_order, ",
        "is_deleted, create_time, ",
        "update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{sortOrder,jdbcType=INTEGER}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SongStyle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @InsertProvider(type=SongStyleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SongStyle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @SelectProvider(type=SongStyleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_order", property="sortOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SongStyle> selectByExample(SongStyleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @Select({
        "select",
        "id, name, sort_order, is_deleted, create_time, update_time",
        "from t_song_style",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_order", property="sortOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SongStyle selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @UpdateProvider(type=SongStyleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SongStyle record, @Param("example") SongStyleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @UpdateProvider(type=SongStyleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SongStyle record, @Param("example") SongStyleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @UpdateProvider(type=SongStyleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SongStyle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_song_style
     *
     * @mbg.generated Wed Aug 24 23:59:46 CST 2016
     */
    @Update({
        "update t_song_style",
        "set name = #{name,jdbcType=VARCHAR},",
          "sort_order = #{sortOrder,jdbcType=INTEGER},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SongStyle record);
}