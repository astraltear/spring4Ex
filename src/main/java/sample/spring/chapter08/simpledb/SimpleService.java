package sample.spring.chapter08.simpledb;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SimpleService")
public class SimpleService {
	
	@Autowired
	private SimpleDao simpleDao;
	
	public int insertData(SimpleDTO simpleDTO) {
		return simpleDao.insertData(simpleDTO);
	}
	
	public SimpleDTO getDataSingle(int id) {
		return simpleDao.getDataSingle(id);
	}
	
	public int use_JdbcTemplate(SimpleDTO simpleDTO) {
		return simpleDao.use_JdbcTemplate(simpleDTO);
	}
	
	public List<SimpleDTO> findAll() throws ParseException {
		return simpleDao.findAll();
	}
	
	public String getName(int id) {
		return simpleDao.getName(id);
	}

}
