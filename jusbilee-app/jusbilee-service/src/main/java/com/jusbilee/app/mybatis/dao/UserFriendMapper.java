package com.jusbilee.app.mybatis.dao;

import com.jusbilee.app.mybatis.pojo.UserFriend;
import com.jusbilee.app.mybatis.pojo.UserFriendCriteria;
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

public interface UserFriendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=UserFriendSqlProvider.class, method="countByExample")
    long countByExample(UserFriendCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @DeleteProvider(type=UserFriendSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserFriendCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Delete({
        "delete from t_user_friend",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Insert({
        "insert into t_user_friend (user_id, friend_user_id, ",
        "is_deleted, create_time, ",
        "update_time)",
        "values (#{userId,jdbcType=BIGINT}, #{friendUserId,jdbcType=BIGINT}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserFriend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @InsertProvider(type=UserFriendSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserFriend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @SelectProvider(type=UserFriendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="friend_user_id", property="friendUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserFriend> selectByExample(UserFriendCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Select({
        "select",
        "id, user_id, friend_user_id, is_deleted, create_time, update_time",
        "from t_user_friend",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="friend_user_id", property="friendUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserFriend selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserFriendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserFriend record, @Param("example") UserFriendCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserFriendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserFriend record, @Param("example") UserFriendCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @UpdateProvider(type=UserFriendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserFriend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_friend
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    @Update({
        "update t_user_friend",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "friend_user_id = #{friendUserId,jdbcType=BIGINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserFriend record);
}