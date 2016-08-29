package com.jusbilee.app.module.stage.request;


import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/8/24.
 */
public class UserStageRequests {
    public static class UserStageData {
        @NotNull(message = "stageSongId不能为空")
        private Integer stageSongId;

        @NotNull(message = "score不能为空")
        private Integer score;

        private Long assistUserId;

        public Integer getStageSongId() {
            return stageSongId;
        }

        public void setStageSongId(Integer stageSongId) {
            this.stageSongId = stageSongId;
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
}
