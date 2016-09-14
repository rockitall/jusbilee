package com.jusbilee.app.api.song.domain;


import java.io.Serializable;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiSong implements Serializable {
    private Integer songId;
    private String songName;
    private String description;
    private String iconUrl;
    private String wavPlayUrl;
    private String midiPlayUrl;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getWavPlayUrl() {
        return wavPlayUrl;
    }

    public void setWavPlayUrl(String wavPlayUrl) {
        this.wavPlayUrl = wavPlayUrl;
    }

    public String getMidiPlayUrl() {
        return midiPlayUrl;
    }

    public void setMidiPlayUrl(String midiPlayUrl) {
        this.midiPlayUrl = midiPlayUrl;
    }
}
