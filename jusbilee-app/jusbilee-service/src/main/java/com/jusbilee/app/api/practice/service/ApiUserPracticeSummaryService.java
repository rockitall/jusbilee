/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.service;

import com.jusbilee.app.api.practice.dao.ApiUserPracticeSummaryDao;
import com.jusbilee.app.api.practice.domain.ApiUserPracticeSummary;
import com.jusbilee.app.api.practice.domain.UnlockType;
import com.jusbilee.app.mybatis.dao.UserPracticeSummaryMapper;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.UserPracticeSummary;
import com.jusbilee.app.mybatis.pojo.UserPracticeSummaryCriteria;
import com.rockit.core.pojo.Pagination;
import com.rockit.core.utils.IdentityUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhandc 2016年9月2日
 */

@Service
public class ApiUserPracticeSummaryService {
    @Autowired
    private ApiUserPracticeSummaryDao apiUserPracticeSummaryDao;

    @Autowired
    private UserPracticeSummaryMapper userPracticeSummaryMapper;

    public List<ApiUserPracticeSummary> getUserPracticeSummaryListByStyleId(Long userId, Integer styleId, Pagination pagination) {
        return apiUserPracticeSummaryDao.getByStyleId(userId, styleId, pagination);
    }

    public Map<Integer, ApiUserPracticeSummary> getUserPracticeSummaryListBySongIdListAsMap(@Param("userId") Long userId, List<Integer> songIdList) {
        List<ApiUserPracticeSummary> stats = apiUserPracticeSummaryDao.getBySongIdList(userId, songIdList);
        return IdentityUtils.asMap(stats, v -> v.getSongId());
    }


    public int addUserPracticeSummaryViaUnlock(Long userId, PracticeSong song, UnlockType type) {
        UserPracticeSummary summary = new UserPracticeSummary();
        summary.setUserId(userId);
        summary.setSongId(song.getSongId());
        summary.setUnlockType(type.getValue());
        summary.setPracticeSongId(song.getId());
        summary.setStyleId(song.getStyleId());
        summary.setCreateTime(new Date());

        userPracticeSummaryMapper.insertSelective(summary);
        return summary.getId();
    }

    public UserPracticeSummary getUserPracticeSummaryBySongId(Integer songId) {
        UserPracticeSummaryCriteria criteria = new UserPracticeSummaryCriteria();
        criteria.createCriteria().andSongIdEqualTo(songId);
        List<UserPracticeSummary> list = userPracticeSummaryMapper.selectByExample(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    public void update(UserPracticeSummary update) {
        userPracticeSummaryMapper.updateByPrimaryKeySelective(update);
    }
}
