/**
 * zhandc 2016年8月7日
 */
package com.jusbilee.app.admin.domain;

import com.jusbilee.app.api.user.account.domain.AppUser;
import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月7日
 */
public class AppUserCriteria extends Pager<AppUser> {

    private String cycleType; //0：天， 1周
    private String date;
    private String startDate;
    private String endDate;

    /**
     * @return the cycleType
     */
    public String getCycleType() {
        return cycleType;
    }

    /**
     * @param cycleType the cycleType to set
     */
    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
