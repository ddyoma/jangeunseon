package com.test.sp1.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.sp1.dao.UserInfoDAO;
import com.test.sp1.entity.UserInfo;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

	@PersistenceContext
	private EntityManager em;

//	@Autowired
//	private DataSource ds;

	
	//총괄셀렉트
	@Override
	public List<UserInfo> getUserInfoList() {

//		List<UserInfo> ul = new ArrayList<>();
//		String sql = "select * from user_info";
//		try(Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){//성공하든 실패하든 클로즈하게 만든다.
//			try(ResultSet rs = ps.executeQuery()){
//				while(rs.next()) {
//					UserInfo userInfo = new UserInfo();
//					userInfo.setUiNum(rs.getInt("ui_num"));
//					ul.add(userInfo);
//				}
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();     
//		}
//		
//		ul.add(new UserInfo());    다필요없어

		List<UserInfo> ul = em.createQuery("from UserInfo ui", UserInfo.class).getResultList();
		return ul;
	}

	
	//단일셀렉트
	@Override
	public UserInfo findUserInfo(int uiId) {
		
		return em.find(UserInfo.class, uiId);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
	
		em.merge(userInfo);
	 //데이터베이스와 동기화 시키는부분
	
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) {

		em.persist(userInfo);
		
		
	}

	@Override
	public void deleteUserinfo(int uiId) {
		
		UserInfo u = findUserInfo(uiId);
		em.remove(u);
		
	}

}
