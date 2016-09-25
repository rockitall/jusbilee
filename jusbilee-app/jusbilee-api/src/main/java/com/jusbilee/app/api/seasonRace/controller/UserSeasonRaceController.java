/**
 * zhandc 2016年9月22日
 */
package com.jusbilee.app.api.seasonRace.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceRank;
import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceSummaryDomain;
import com.jusbilee.app.api.seasonRace.manager.ApiSeasonRaceGameManager;
import com.jusbilee.app.api.seasonRace.manager.UserSeasonRaceManager;
import com.jusbilee.app.api.seasonRace.request.RateResultRequest;
import com.jusbilee.app.api.seasonRace.response.RaceDetailFacade;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年9月22日
 *
 */

@Controller
@RequestMapping("/user/season/race")
public class UserSeasonRaceController extends BaseController {

	@Autowired
	private UserSeasonRaceManager userSeasonRaceManager;
	
	@Autowired
	private ApiSeasonRaceGameManager apiSeasonRaceGameManager;

	@RequestMapping("/summary")
	public JsonResult getUserSeasonRaceSummary() {
		Long userId = HttpContext.current().getUserId();
		UserSeasonRaceSummaryDomain summary = userSeasonRaceManager.getUserSeasonRaceSummary(userId);
		return ok(summary);
	}

	@RequestMapping("/allRank")
	public JsonResult getSeasonRank(@ModelAttribute Pagination pagination,
			BindingResult bindingResult) {
		assertValid(bindingResult);
		Long userId = HttpContext.current().getUserId();
		List<UserSeasonRaceRank> resultList = userSeasonRaceManager.getSeasonRank(userId, pagination);
		return ok(resultList);
	}
	
	@RequestMapping("/friendsRank")
	public JsonResult getFriendsSeasonRank(@ModelAttribute Pagination pagination,
			BindingResult bindingResult) {
		assertValid(bindingResult);
		Long userId = HttpContext.current().getUserId();
		List<UserSeasonRaceRank> resultList = userSeasonRaceManager.getFriendsSeasonRank(userId, pagination);
		return ok(resultList);
	}
	
	@RequestMapping("/startGame")
	public JsonResult getRaceDetail() {
		Long userId = HttpContext.current().getUserId();
		RaceDetailFacade facade = apiSeasonRaceGameManager.getRaceDetail(userId);
		return ok(facade);
	}
	
	@RequestMapping("/log")
    public JsonResult practice(@Valid @ModelAttribute RateResultRequest request,
                               BindingResult bindingResult) {
        assertValid(bindingResult);
        apiSeasonRaceGameManager.RateResultLog(request);
        return ok();
    }

}
