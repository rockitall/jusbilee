package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.request.StageLevelRequest;
import com.jusbilee.app.api.stage.service.StageLevelService;
import com.jusbilee.app.mybatis.pojo.StageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/1.
 */
@Service
public class StageLevelManager {
    @Autowired
    private StageLevelService stageLevelService;

    public List<StageLevel> list() {
        return stageLevelService.list();
    }

    public void addStageLevel(StageLevelRequest request) {
        StageLevel level = new StageLevel();
        level.setName(request.getName());
        level.setWeight(request.getWeight());

        stageLevelService.addStageLevel(level);
    }

    public void updateStageLevel(Integer stageLevelId, StageLevelRequest request) {
        StageLevel level = new StageLevel();
        level.setId(stageLevelId);
        level.setWeight(request.getWeight());
        level.setName(request.getName());

        stageLevelService.updateStageLevel(level);
    }

    public void deleteStageLevel(Integer stageLevelId) {
        stageLevelService.deleteStageLevel(stageLevelId);
    }
}
