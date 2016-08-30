/**
 * zhandc 2016年8月8日
 */
package com.jusbilee.app.admin.user.controller;

import com.jusbilee.app.admin.domain.AppUserCriteria;
import com.jusbilee.app.admin.domain.UserArchive;
import com.jusbilee.app.admin.domain.UserArchiveCriteria;
import com.jusbilee.app.admin.service.AppUserAdminService;
import com.jusbilee.app.admin.service.UserArchiveService;
import com.jusbilee.app.api.user.account.domain.AppUser;
import com.jusbilee.app.api.user.account.param.PasswordModification;
import com.jusbilee.app.api.user.account.service.IUserAccountService;
import com.jusbilee.app.base.BaseController;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author zhandc 2016年8月8日
 */

// @RestController
@RequestMapping("/appUser/manage")
public class AppUserAdminController extends BaseController {

    @Autowired
    private AppUserAdminService appUserAdminService;

    private IUserAccountService userAccountService;

    private UserArchiveService userArchiveService;

    /**
     * app用户列表查询，包括日、周的统计
     * 相关区分可以根据参数
     *
     * @param criteria
     * @param bindingResult
     * @return
     */
    @RequestMapping("/query")
    public JsonResult query(@Valid @ModelAttribute AppUserCriteria criteria, BindingResult bindingResult) {
        assertValid(bindingResult);
        appUserAdminService.queryAppUser(criteria);
        return ok(criteria);
    }

    /**
     * app用户基本信息查询
     *
     * @param userId
     * @return
     */
    @RequestMapping("/selectById")
    public JsonResult selectById(@RequestParam(value = "userId", required = true) long userId) {
//		AppUser appUser = userAccountService.getUserInfo(userId);
        return ok();
    }

    /**
     * app用户基本信息修改
     *
     * @param appUser
     * @param bindingResult
     * @return
     */
    @RequestMapping("/updateAppUser")
    public JsonResult updateAppUser(@Valid @ModelAttribute AppUser appUser, BindingResult bindingResult) {
        assertValid(bindingResult);
//		userAccountService.updateAppUser(appUser);
        return ok();
    }

    /**
     * 帮助app用户重置(修改)密码
     *
     * @param modification
     * @param bindingResult
     * @return
     */
    @RequestMapping("/pwd/modify")
    public JsonResult modifyPassword(@Valid @ModelAttribute PasswordModification modification, BindingResult bindingResult) {
        assertValid(bindingResult);
        userAccountService.modifyPassword(modification);
        return ok();
    }

    /**
     * app用户权限，金币，等更改
     *
     * @param userArchive
     * @param bindingResult
     * @return
     */
    @RequestMapping("/modify")
    public JsonResult modifyUserArchive(@Valid @ModelAttribute UserArchive userArchive, BindingResult bindingResult) {
        assertValid(bindingResult);
        userArchiveService.updateUserArchive(userArchive);
        return ok();
    }


    @RequestMapping("/selectByIdUserArchive")
    public JsonResult selectByIdUserArchive(@RequestParam(value = "userId", required = true) long userId) {
        UserArchive userArchive = userArchiveService.selectById(userId);
        return ok(userArchive);
    }

    @RequestMapping("/selectUserArchiveDetial")
    public JsonResult selectUserArchiveDetial(@RequestParam(value = "userId", required = true) long userId) {
        UserArchive userArchive = userArchiveService.selectUserArchive(userId);
        return ok(userArchive);
    }


    @RequestMapping("/queryFriends")
    public JsonResult queryFriends(@Valid @ModelAttribute UserArchiveCriteria criteria, BindingResult bindingResult) {
        assertValid(bindingResult);
        userArchiveService.query(criteria);
        return ok(criteria);
    }
}
