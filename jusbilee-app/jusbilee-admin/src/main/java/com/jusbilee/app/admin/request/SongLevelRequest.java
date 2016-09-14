package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class SongLevelRequest {
    @NotEmpty(message = "名称不能为空")
    @Length(max = 16, message = "名称不能超过16个字符")
    private String name;

    @NotNull(message = "难易程度不能为空")
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}