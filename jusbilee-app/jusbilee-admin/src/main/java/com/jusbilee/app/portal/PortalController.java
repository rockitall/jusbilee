package com.jusbilee.app.portal;

import com.jusbilee.app.mybatis.dao.SongMapper;
import com.jusbilee.app.mybatis.pojo.SongCriteria;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2016/7/15.
 */

@Controller
public class PortalController {
    @Autowired
    private SongMapper songMapper;

    @RequestMapping("/index")
    public String hello(HttpServletRequest request) {
        SongCriteria criteria = new SongCriteria();
        criteria.createCriteria().andIdEqualTo(1);
        criteria.setLimit(10);
        criteria.setOffset(0);

        System.out.println(songMapper.selectByExample(criteria));
        return "main";
    }
}
