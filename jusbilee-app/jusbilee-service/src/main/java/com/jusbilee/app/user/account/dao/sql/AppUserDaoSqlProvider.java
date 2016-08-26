package com.jusbilee.app.user.account.dao.sql;

import com.jusbilee.app.user.account.domain.AppUser;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Allen on 2016/7/16.
 */

public class AppUserDaoSqlProvider {
    public String insert(AppUser appUser) {
        return new SQL() {{
            INSERT_INTO("t_app_user");
            if (appUser.getNickname() != null) {
                VALUES("nickname", "#{nickname}");
            }
            if (appUser.getAvatar() != null) {
                VALUES("avatar", "#{avatar}");
            }
            if (appUser.getDescription() != null) {
                VALUES("description", "#{description}");
            }
            if (appUser.getSex() != null) {
                VALUES("sex", "#{sex}");
            }
            if (appUser.getProvince() != null) {
                VALUES("province", "#{province}");
            }
            if (appUser.getCity() != null) {
                VALUES("city", "#{city}");
            }
            if (appUser.getBirthday() != null) {
                VALUES("birthday", "#{birthday}");
            }
            VALUES("create_time", "now()");
        }}.toString();
    }
}
