package com.youngjee.db;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySqlAIWithMyBatis {
	
	private static final String namespace="com.youngjee.db.mapper.MemberMapper";
	
	private static Logger logger = LoggerFactory.getLogger(MySqlAIWithMyBatis.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:MySqlAIWithMyBatis.xml");
		
		SqlSession sqlSession =  (SqlSession) context.getBean("sqlSession");
		
//		System.out.println(sqlSession);
		
		String currentDate = sqlSession.selectOne(namespace+".getTime");
		
		System.out.println(currentDate);
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid("userid");
		memberVO.setUsername("username");
		memberVO.setUserpw("userpw");
		memberVO.setEmail("email");
		
		System.out.println("before insert:"+memberVO.getUser_no());
		int result = sqlSession.insert(namespace+".insertMember", memberVO);
//		System.out.println(result);
		
		System.out.println("after insert:"+memberVO.getUser_no());
		
	}

}
