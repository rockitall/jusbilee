package com.jusbilee.app.api.practice.dao.sql;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiSongStyleDaoSqlProvider {
    public static final String ALL_STYLE_SQL = "select id as styleId,"
            + " name as styleName"
            + " from t_song_style"
            + " where is_deleted=0"
            + " order by sort_order asc,id asc";
}
