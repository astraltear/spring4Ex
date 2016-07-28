package com.astraltear.db;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.astraltear.vo.InOutProcVO;

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
		
		HashMap<String, Object> map1 = new HashMap<String,Object>();
		map1.put("param1", 1);
		map1.put("param2", 0);
		map1.put("param3", "");
		
		sqlSession.selectOne(namespace+".getProcMethod1",map1);
		System.out.println("getProcMethod1 map param2:"+map1.get("param2"));
		System.out.println("getProcMethod1 map param3:"+map1.get("param3"));
		
		HashMap<String, Object> map2 = new HashMap<String,Object>();
		map2.put("param1", 1);
		map2.put("param2", 0);
		map2.put("param3", "");
		
		sqlSession.selectOne(namespace+".getProcMethod2",map2);
		System.out.println("getProcMethod2 map param2:"+map2.get("param2"));
		System.out.println("getProcMethod2 map param3:"+map2.get("param3"));
		
		InOutProcVO inOutProcVO = new InOutProcVO();
		inOutProcVO.setParam1(1);
		
		sqlSession.selectOne(namespace+".getProcMethod3",inOutProcVO);
		System.out.println("inOutProcVO=>"+inOutProcVO.toString());
	}

}
