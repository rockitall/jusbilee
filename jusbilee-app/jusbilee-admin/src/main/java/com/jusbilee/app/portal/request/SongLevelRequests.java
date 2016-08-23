package com.jusbilee.app.portal.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Allen on 2016/8/23.
 */
public class SongLevelRequests {
    public static class SongLevelParam {
        @NotEmpty(message = "名称不能为空")
        @Length(max = 16, message = "名称不能超过16个字符")
        private String name;
        private Integer order = 1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }
}
