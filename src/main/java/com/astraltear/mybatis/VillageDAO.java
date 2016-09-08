package com.astraltear.mybatis;

import org.apache.ibatis.session.SqlSession;

public class VillageDAO {
	public int save(Village village) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		int result = mapper.insertVillage(village);
		session.commit();
		session.close();
		
		return result;
	}

	public int update(Village village) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		int result = mapper.updateVillage(village);
		session.commit();
		session.close();
		
		return result;
	}

	public int delete(Integer id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		int result = mapper.deleteVillage(id);
		session.commit();
		session.close();
		
		return result;
	}

	public Village getData(Integer id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		VillageMapper mapper = session.getMapper(VillageMapper.class);
		Village village = mapper.selectVillage(id);
		session.close();
		return village;
	}
}
