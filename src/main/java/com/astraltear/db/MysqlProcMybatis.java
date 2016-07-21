package com.astraltear.db;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MysqlProcMybatis {
	
//	http://stove99.tistory.com/78
	
/*
CREATE PROCEDURE `InOutProc`(IN `param1` INT, OUT `param2` INT, OUT `param3` VARCHAR(50))
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT ''
BEGIN

set param2 := 2;
set param3 :='returnParam3';

END
 */

	private static final String namespace = "com.youngjee.db.mapper.MemberMapper";

	private static Logger logger = LoggerFactory.getLogger(MysqlProcMybatis.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:MySqlAIWithMyBatis.xml");

		SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
		
		InOutProcVO inOutProcVO = new InOutProcVO();
		inOutProcVO.setParam1(1);
		
		Map map = sqlSession.selectOne(namespace+".getProcValues",inOutProcVO);
		
//		System.out.println("result::"+inOutProcVO);
		System.out.println(map.size());
	}

}
