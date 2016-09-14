package com.jusbilee.app.admin.criteria;

/**
 * Created by Allen on 2016/9/3.
 */
public class AdminSongQueryCriteria {
    private String name;
    private Integer levelId;
    private Integer styleId;
    private Boolean stageModel;
    private Boolean practiceModel;
    private String startTime;
    private String endTime;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Boolean getPracticeModel() {
        return practiceModel;
    }

    public void setPracticeModel(Boolean practiceModel) {
        this.practiceModel = practiceModel;
    }

    public Boolean getStageModel() {
        return stageModel;
    }

    public void setStageModel(Boolean stageModel) {
        this.stageModel = stageModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
