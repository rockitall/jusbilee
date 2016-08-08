package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.domain.SysUser;
import org.apache.ibatis.jdbc.SQL;


/**
 * Created by Allen on 2016/8/2.
 */
public class SysUserDaoSqlProvider {

    public String selectByCriteria(SysUser sysUser) {
        return new SQL() {
            {
            }
        }.toString();
    }
}
