package com.test.sp1;


import javax.sql.DataSource;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.sp1.bean.Action;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BeanTest {
private static final Logger log = LoggerFactory.getLogger(BeanTest.class);
@Autowired
@Qualifier("objm")
private ObjectMapper om;
//알트 시프트 x  +  t    
//ttd개발방법론

@Autowired
private XMLBeanTest xmlbean;

@Autowired
private DataSource ds;

@Autowired
private Father father;

@Autowired
private Son son;

@Autowired
@Qualifier("dog") //인터페이스 Action을 상속받는 dog와 cat. 둘중 어느걸 바라볼건지 퀄리파이어로 정해야 정상작동
private Action a;

@Test
	public void test() {
		
		log.debug("om=>{}",om);
		log.info("om=>{}",om);
		log.debug("xmlbean.om=>{}",xmlbean.getOm());
		log.debug("ds=>{}",ds);
		log.debug("father=>{}",father);
		log.debug("son=>{}",son);
		a.eat();  //이거 정상작동
	}

}
