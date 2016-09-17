package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/9/15.
 */
public class SongSubLevelRequest {
    @NotNull(message = "levelId不能为空")
    private Integer levelId;

    @NotEmpty(message = "段位名称不能为空")
    @Length(max = 16, message = "段位名称不能超过16个字符")
    private String subLevelName;

    @NotNull(message = "段位分值不能为空")
    private Integer score;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getSubLevelName() {
        return subLevelName;
    }

    public void setSubLevelName(String subLevelName) {
        this.subLevelName = subLevelName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
