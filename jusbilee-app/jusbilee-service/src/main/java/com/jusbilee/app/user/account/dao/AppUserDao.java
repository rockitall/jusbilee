package com.jusbilee.app.user.account.dao;

import com.jusbilee.app.user.account.dao.sql.AppUserDaoSqlProvider;
import com.jusbilee.app.user.account.domain.AppUser;
import com.jusbilee.app.user.account.domain.UserSummary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface AppUserDao {
    @InsertProvider(type = AppUserDaoSqlProvider.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
    void insert(AppUser appUser);

    @Select("select is_locked from t_app_user where id=#{userId}")
    Byte getLockStatus(@Param("userId") Long userId);

    @Select("select nickname, avatar, sex, description, province, city, birthday from t_app_user where id=#{userId}")
    AppUser selectById(@Param("userId") Long userId);

    @Select("select id from t_app_user where id=#{userId}")
    Long checkExistsById(@Param("userId") Long userId);

    @Update("update t_app_user set avatar=#{avatarUrl} where id=#{userId}")
    void updateAvatar(@Param("userId") Long userId, @Param("avatarUrl") String avatarUrl);

    @Update("update t_app_user set nickname=#{nicnkame} where id=#{userId}")
    void updateNickname(@Param("userId") Long userId, @Param("nicnkame") String nicnkame);

    @Select("select total_gold_coin,total_practice_time,total_practice_score,total_practice_count,unlock_practice_song_count,match_count,match_win_count,date_format(last_practice_time, '%Y-%m-%d') as last_practice_time from t_user_summary where user_id=#{userId}")
    @Results({
            @Result(column = "total_gold_coin", property = "totalGoldCoin", jdbcType = JdbcType.INTEGER),
            @Result(column = "total_practice_time", property = "totalPracticeTime", jdbcType = JdbcType.INTEGER),
            @Result(column = "total_practice_score", property = "totalPracticeScore", jdbcType = JdbcType.INTEGER),
            @Result(column = "total_practice_count", property = "totalPracticeCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "unlock_practice_song_count", property = "unlockPracticeSongCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "match_count", property = "matchCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "match_win_count", property = "matchWinCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "last_practice_time", property = "lastPracticeTime", jdbcType = JdbcType.CHAR),
    })
    UserSummary getUserSummary(@Param("userId") Long userId);

    @Insert("insert into t_user_summary(user_id) values (#{userId})")
    void initUserSummary(@Param("userId") Long userId);
}
