package com.jusbilee.app.admin.request;

import com.rockit.core.constraints.annotation.DateTime;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Allen on 2016/9/15.
 */
public class RaceSeasonRequest {
    @NotEmpty(message = "赛季名称不能为空")
    @Length(max = 16, message = "赛季名称长度不能超过16个字符")
    private String seasonName;
    @DateTime
    private String startTime;
    @DateTime
    private String endTime;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
