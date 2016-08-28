package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.Passport;
import com.jusbilee.app.mybatis.pojo.PassportCriteria;
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

public interface PassportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=PassportSqlProvider.class, method="countByExample")
    long countByExample(PassportCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @DeleteProvider(type=PassportSqlProvider.class, method="deleteByExample")
    int deleteByExample(PassportCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Delete({
        "delete from t_passport",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Insert({
        "insert into t_passport (user_id, username, ",
        "password, salt, ",
        "create_time, update_time)",
        "values (#{userId,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Passport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @InsertProvider(type=PassportSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Passport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=PassportSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Passport> selectByExample(PassportCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Select({
        "select",
        "id, user_id, username, password, salt, create_time, update_time",
        "from t_passport",
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
    Passport selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=PassportSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Passport record, @Param("example") PassportCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=PassportSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Passport record, @Param("example") PassportCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=PassportSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Passport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_passport
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Update({
        "update t_passport",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Passport record);
}