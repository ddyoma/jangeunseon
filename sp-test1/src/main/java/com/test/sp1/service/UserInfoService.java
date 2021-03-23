package com.test.sp1.service;

import java.util.List;

import com.test.sp1.entity.UserInfo;

public interface UserInfoService {
	List<UserInfo> getUserInfoList();
	UserInfo findUserInfo(int uiId);  //단일셀렉트
	int updateUserInfo(UserInfo userInfo);
	int deleteUserinfo(int uiId);
	int saveUserInfo(UserInfo userInfo);
}
