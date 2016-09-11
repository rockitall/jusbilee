package com.jusbilee.app.api.stage.dao;

import com.jusbilee.app.api.stage.dao.sql.UserStageSummaryDaoSqlProvider;
import com.jusbilee.app.api.stage.domain.ApiStageLevelSongCount;
import com.jusbilee.app.api.stage.domain.ApiUserStageSummary;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
@Mapper
public interface ApiUserStageSummaryDao {
    @Select(UserStageSummaryDaoSqlProvider.GET_USER_STAGE_PASSED_COUNT_SQL)
    List<ApiStageLevelSongCount> getUserAllStageLevelPassedSongCount(@Param("userId") Long userId);

    @SelectProvider(type = UserStageSummaryDaoSqlProvider.class, method = "getUserStageSummaryListBySongIdListSql")
    List<ApiUserStageSummary> selectBySongIdList(@Param("userId") Long userId, List<Integer> songIdList);

    @Update("update t_user_stage_summary set stage_count=stage_count+1 where id=#{id}")
    void increaseStageCountById(@Param("id") Integer id);

    @Update("update t_user_stage_summary set score=#{score},is_assist=1,assist_user_id=#{assistUserId} where id=#{id}")
    void updateScoreWithAssistById(@Param("id") Integer id, @Param("score") Integer score, @Param("assistUserId") Long assistUserId);

    @Update("update t_user_stage_summary set score=#{score},is_assist=0,assist_user_id=0 where id=#{id}")
    void updateScoreWithoutAssistById(Integer id, Integer score);
}
