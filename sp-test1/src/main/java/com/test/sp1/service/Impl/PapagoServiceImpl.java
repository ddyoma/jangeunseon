package com.test.sp1.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sp1.api.PapagoAPI;
import com.test.sp1.entity.papago.PapagoParam;
import com.test.sp1.entity.papago.PapagoResult;
import com.test.sp1.service.PapagoService;

@Service
public class PapagoServiceImpl implements PapagoService {

	@Autowired
	private PapagoAPI pAPI;
	
	@Override
	public PapagoResult getPapagoResult(PapagoParam pp) {
		return pAPI.getResult(pp);
	}

}
