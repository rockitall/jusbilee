/**
 * zhandc 2016年9月6日
 */
package com.jusbilee.app.api.song.dao.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author zhandc 2016年9月6日
 */
public class ApiSongDaoSqlProvider {
    public String getSongListByIdListSql(@Param("idList") List<Integer> songIdList) {
        SQL sql = new SQL();
        sql.SELECT("id as songId");
        sql.SELECT("name as songName");
        sql.SELECT("description as description");
        sql.SELECT("icon_url as iconUrl");
        sql.SELECT("opern_screenshot_url as opernScreenshotUrl");
        sql.SELECT("opern_url as opernUrl");
        sql.SELECT("wav_play_url as wavPlayUrl");
        sql.SELECT("midi_play_url as midiPlayUrl");
        sql.FROM("t_song");
        sql.WHERE("is_deleted=0");
        StringBuilder buf = new StringBuilder(256);
        sql.usingAppender(buf);
        buf.append(" and id in (");
        for (Integer id : songIdList) {
            buf.append(id).append(',');
        }
        buf.setCharAt(buf.length() - 1, ')');
        return buf.toString();
    }
}
