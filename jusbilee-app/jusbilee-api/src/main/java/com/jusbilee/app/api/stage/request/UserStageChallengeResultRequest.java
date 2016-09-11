package com.jusbilee.app.api.stage.request;


import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/8/24.
 */
public class UserStageChallengeResultRequest {
    @NotNull(message = "songId")
    private Integer songId;
    @NotNull(message = "score不能为空")
    private Integer score;
    private Long assistUserId;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getAssistUserId() {
        return assistUserId;
    }

    public void setAssistUserId(Long assistUserId) {
        this.assistUserId = assistUserId;
    }
}
