package com.astraltear.mybatis;

public class RunMybatis {
	public static void main(String[] args) {
		VillageDAO villageDAO = new VillageDAO();

		// insert
		Village village = new Village();
		village.setVid(1);
		village.setVillageName("Crossing Republic");
		village.setDistrict("Ghaziabad");
		int result = villageDAO.save(village);
		System.out.println("---Data saved---:" + result);

		// update
		village = new Village();
		village.setVid(1);
		village.setVillageName("Dhananjaypur");
		village.setDistrict("Varanasi");
		result = villageDAO.update(village);
		System.out.println("---Data updated---:" + result);

		// select
		village = villageDAO.getData(1);
		System.out.println(village);
		
		//delete
		result = villageDAO.delete(1);
		 System.out.println("---Data deleted---:"+result);
	}
}
