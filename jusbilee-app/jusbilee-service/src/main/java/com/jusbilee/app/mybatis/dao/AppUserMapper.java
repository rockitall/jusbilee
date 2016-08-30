package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.AppUser;
import com.jusbilee.app.mybatis.pojo.AppUserCriteria;
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

public interface AppUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=AppUserSqlProvider.class, method="countByExample")
    long countByExample(AppUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @DeleteProvider(type=AppUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Delete({
        "delete from t_app_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Insert({
        "insert into t_app_user (nickname, description, ",
        "sex, avatar, birthday, ",
        "province, city, ",
        "points, friend_count, ",
        "is_locked, status, ",
        "create_time, update_time)",
        "values (#{nickname,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=CHAR}, #{avatar,jdbcType=VARCHAR}, #{birthday,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{points,jdbcType=INTEGER}, #{friendCount,jdbcType=INTEGER}, ",
        "#{isLocked,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @InsertProvider(type=AppUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=AppUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="friend_count", property="friendCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_locked", property="isLocked", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppUser> selectByExample(AppUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Select({
        "select",
        "id, nickname, description, sex, avatar, birthday, province, city, points, friend_count, ",
        "is_locked, status, create_time, update_time",
        "from t_app_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="friend_count", property="friendCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_locked", property="isLocked", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AppUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=AppUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppUser record, @Param("example") AppUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=AppUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppUser record, @Param("example") AppUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=AppUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_user
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Update({
        "update t_app_user",
        "set nickname = #{nickname,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=CHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "points = #{points,jdbcType=INTEGER},",
          "friend_count = #{friendCount,jdbcType=INTEGER},",
          "is_locked = #{isLocked,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AppUser record);
}