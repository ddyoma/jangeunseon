package com.test.sp1.dao;

import java.util.List;

import com.test.sp1.entity.UserInfo;

public interface UserInfoDAO {
	List<UserInfo> getUserInfoList();
	UserInfo findUserInfo(int uiId); //단일샐랙트
	void updateUserInfo(UserInfo userInfo);
	void deleteUserinfo(int uiId);
	void saveUserInfo(UserInfo userInfo);

}
