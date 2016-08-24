package com.jusbilee.app.stage.domain;

/**
 * Created by Allen on 2016/8/24.
 */
public class UserStageLevel {
    private Integer stageLevelId;
    private String name;
    private Integer total;
    private Integer passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Integer getStageLevelId() {
        return stageLevelId;
    }

    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }
}
