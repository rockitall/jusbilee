package com.jusbilee.app.api.practice.param;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Allen on 2016/9/28.
 */
public class ApiPracticeSongCriteria {
    @NotEmpty
    private String keyword;
    private Integer styleId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }
}
