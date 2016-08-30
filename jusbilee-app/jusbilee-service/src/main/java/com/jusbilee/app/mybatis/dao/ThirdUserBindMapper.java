package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.ThirdUserBind;
import com.jusbilee.app.mybatis.pojo.ThirdUserBindCriteria;
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

public interface ThirdUserBindMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=ThirdUserBindSqlProvider.class, method="countByExample")
    long countByExample(ThirdUserBindCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @DeleteProvider(type=ThirdUserBindSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThirdUserBindCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Delete({
        "delete from t_third_user_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Insert({
        "insert into t_third_user_bind (user_id, username, ",
        "password, salt, ",
        "create_time, update_time)",
        "values (#{userId,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThirdUserBind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @InsertProvider(type=ThirdUserBindSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThirdUserBind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=ThirdUserBindSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ThirdUserBind> selectByExample(ThirdUserBindCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Select({
        "select",
        "id, user_id, username, password, salt, create_time, update_time",
        "from t_third_user_bind",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ThirdUserBind selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=ThirdUserBindSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThirdUserBind record, @Param("example") ThirdUserBindCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=ThirdUserBindSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThirdUserBind record, @Param("example") ThirdUserBindCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=ThirdUserBindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThirdUserBind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_third_user_bind
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Update({
        "update t_third_user_bind",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThirdUserBind record);
}