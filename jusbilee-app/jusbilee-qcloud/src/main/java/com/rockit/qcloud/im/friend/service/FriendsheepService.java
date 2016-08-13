package com.rockit.qcloud.im.friend.service;

import com.rockit.qcloud.im.common.QCloudApiRequest;
import com.rockit.qcloud.im.common.QCloudHttp;
import com.rockit.qcloud.im.friend.response.AddFriendResponse;
import com.rockit.qcloud.im.friend.response.CheckFriendResponse;
import com.rockit.qcloud.im.friend.response.DeleteFriendResponse;

/**
 * Created by Allen on 2016/8/13.
 */

public class FriendsheepService {
    private QCloudHttp http;

    public AddFriendResponse addFriend(QCloudApiRequest request) {
        return http.post("/", request, AddFriendResponse.class, 1000);
    }

    public DeleteFriendResponse deleteFriend(QCloudApiRequest request) {
        return http.post("/", request, DeleteFriendResponse.class, 1000);
    }

    public CheckFriendResponse checkFriend(QCloudApiRequest request) {
        return http.post("/", request, CheckFriendResponse.class, 1000);
    }

    public QCloudHttp getHttp() {
        return http;
    }

    public void setHttp(QCloudHttp qCloudHttp) {
        this.http = qCloudHttp;
    }
}
