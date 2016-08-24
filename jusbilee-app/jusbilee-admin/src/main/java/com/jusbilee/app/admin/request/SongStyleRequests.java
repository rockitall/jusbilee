package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/8/23.
 */
public class SongStyleRequests {
    public static class SongStyleParam {
        @NotEmpty(message = "名称不能为空")
        @Length(max = 16, message = "名称不能超过16个字符")
        private String name;

        @NotNull(message = "排序不能为空")
        private Integer sortOrder;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
        }
    }
}
