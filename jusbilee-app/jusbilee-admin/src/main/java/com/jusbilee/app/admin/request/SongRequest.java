package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class SongRequest {
    @NotEmpty(message = "名称不能为空")
    @Length(max = 16, message = "名称不能超过16个字符")
    private String name;

    @Length(max = 255, message = "名称不能超过255个字符")
    private String description;

    private MultipartFile iconMultipartFile;
    private MultipartFile screenshotMultipartFile;
    private MultipartFile opernMultipartFile;
    private MultipartFile wavMultipartFile;
    private MultipartFile midiMultipartFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getIconMultipartFile() {
        return iconMultipartFile;
    }

    public void setIconMultipartFile(MultipartFile iconMultipartFile) {
        this.iconMultipartFile = iconMultipartFile;
    }

    public MultipartFile getScreenshotMultipartFile() {
        return screenshotMultipartFile;
    }

    public void setScreenshotMultipartFile(MultipartFile screenshotMultipartFile) {
        this.screenshotMultipartFile = screenshotMultipartFile;
    }

    public MultipartFile getOpernMultipartFile() {
        return opernMultipartFile;
    }

    public void setOpernMultipartFile(MultipartFile opernMultipartFile) {
        this.opernMultipartFile = opernMultipartFile;
    }

    public MultipartFile getWavMultipartFile() {
        return wavMultipartFile;
    }

    public void setWavMultipartFile(MultipartFile wavMultipartFile) {
        this.wavMultipartFile = wavMultipartFile;
    }

    public MultipartFile getMidiMultipartFile() {
        return midiMultipartFile;
    }

    public void setMidiMultipartFile(MultipartFile midiMultipartFile) {
        this.midiMultipartFile = midiMultipartFile;
    }
}