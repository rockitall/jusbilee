package com.jusbilee.app.api.user.account.dao;

import com.jusbilee.app.api.user.account.domain.UserSummary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface ApiUserSummaryDao {
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

    @Select("select total_gold_coin from t_user_summary where user_id=#{userId}")
    int getUserGoldCoin(@Param("userId") Long userId);

    @Update("update t_user_summary set total_gold_coin=total_gold_coin-#{goldCoin},unlock_practice_song_count=unlock_practice_song_count+1 where user_id=#{userId}")
    void consumeUserGoldCoinAndIncreaseUnlockCount(@Param("userId") Long userId, @Param("goldCoin") Integer goldCoin);

    @Update("update t_user_summary set total_gold_coin=total_gold_coin+#{goldCoin} where user_id=#{userId}")
    void produceUserGoldCoin(@Param("userId") Long userId, @Param("goldCoin") Integer goldCoin);

    @Insert("insert into t_user_summary(user_id,create_time) values (#{userId},now())")
    void initUserSummary(@Param("userId") Long userId);

    @Update("update t_user_summary set total_gold_coin=total_gold_coin-#{goldCoin} where user_id=#{userId}")
    void consumeUserGoldCoin(@Param("userId") Long userId, @Param("goldCoin") Integer goldCoin);
}
