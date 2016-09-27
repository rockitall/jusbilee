/**
 * zhandc 2016年9月22日
 */
package com.jusbilee.app.api.race.controller;

import com.jusbilee.app.api.race.manager.ApiSeasonRaceGameManager;
import com.jusbilee.app.api.race.manager.UserSeasonRaceManager;
import com.jusbilee.app.api.race.request.RateResultRequest;
import com.jusbilee.app.api.race.response.RaceDetailFacade;
import com.jusbilee.app.api.race.domain.UserSeasonRaceRank;
import com.jusbilee.app.api.race.domain.UserSeasonRaceSummaryDomain;
import com.jusbilee.app.api.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

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
		Long userId = HttpContext.current().getRequireUserId();
		UserSeasonRaceSummaryDomain summary = userSeasonRaceManager.getUserSeasonRaceSummary(userId);
		return ok(summary);
	}

	@RequestMapping("/rank/all")
	public JsonResult getSeasonRank(@ModelAttribute Pagination pagination,
			BindingResult bindingResult) {
		assertValid(bindingResult);
		Long userId = HttpContext.current().getRequireUserId();
		List<UserSeasonRaceRank> resultList = userSeasonRaceManager.getSeasonRank(userId, pagination);
		return ok(resultList);
	}
	
	@RequestMapping("/rank/friends")
	public JsonResult getFriendsSeasonRank(@ModelAttribute Pagination pagination,
			BindingResult bindingResult) {
		assertValid(bindingResult);
		Long userId = HttpContext.current().getRequireUserId();
		List<UserSeasonRaceRank> resultList = userSeasonRaceManager.getFriendsSeasonRank(userId, pagination);
		return ok(resultList);
	}
	
	@RequestMapping("/game/start")
	public JsonResult getRaceDetail() {
		Long userId = HttpContext.current().getRequireUserId();
		RaceDetailFacade facade = apiSeasonRaceGameManager.getRaceDetail(userId);
		return ok(facade);
	}
	
	@RequestMapping("/game/log")
    public JsonResult practice(@Valid @ModelAttribute RateResultRequest request,
                               BindingResult bindingResult) {
        assertValid(bindingResult);
		HttpContext.current().getRequireUserId();
        apiSeasonRaceGameManager.RateResultLog(request);
        return ok();
    }

}
