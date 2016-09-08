package com.astraltear.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VillageMapper {

/*
CREATE TABLE `village` (
	`id` VARCHAR(50) NULL DEFAULT NULL,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`district` VARCHAR(50) NULL DEFAULT NULL
)
ENGINE=InnoDB
;

 */

	@Results({
        @Result(property = "vid", column = "id"),
        @Result(property = "villageName", column = "name"),
        @Result(property = "district", column = "district")
    })
	
	@Select("SELECT id, name, district from village WHERE id = #{id}")
	Village selectVillage(int id);
	
	@Insert("INSERT into village(id,name,district) VALUES(#{vid}, #{villageName}, #{district})")
	int insertVillage(Village village);
	
	@Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
	int updateVillage(Village village);
	
	@Delete("DELETE FROM village WHERE id =#{id}")
	int deleteVillage(int id);
}
