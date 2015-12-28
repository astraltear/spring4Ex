package sample.spring.chapter08.simpledb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository("simpleDao")
public class SimpleDao {

	private SimpleJdbcInsert jdbcTemplateInsert;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplateInsert = new SimpleJdbcInsert(dataSource).withTableName("simpletable").usingGeneratedKeyColumns("id");
	}
	
	public int insertData(SimpleDTO simpleDTO) {
		Map<String, Object> parameters = new HashMap<String,Object>(4);
		parameters.put("name",simpleDTO.getName());
		parameters.put("sex",simpleDTO.getSex());
		parameters.put("age",simpleDTO.getAge());
		parameters.put("regDate", new java.sql.Date(simpleDTO.getRegDate().getTime()));
		
		Number key = jdbcTemplateInsert.executeAndReturnKey(parameters);
		return key.intValue();
		
	}
	
	public SimpleDTO getDataSingle(int id) {
		String sql = "select * from simpletable where id=?";
//		jdbcTemplate = new JdbcTemplate(dataSource); // xml에서 inject
		SimpleDTO simpleDTO = (SimpleDTO) jdbcTemplate.queryForObject(sql, new Object[] {id},new SimpleDtoRowMapper());
		return simpleDTO;
	}
	
	
	public int use_JdbcTemplate(SimpleDTO simpleDTO) {
		String sql="insert into simpletable(name,sex,age,regDate) values(?,?,?,?)";
		int result= jdbcTemplate.update(sql, new Object[]{simpleDTO.getName(),simpleDTO.getSex(),simpleDTO.getAge(),new java.sql.Date(simpleDTO.getRegDate().getTime())});
		return result;
	}
	
	public List findAll() throws ParseException {
		String sql ="select * from simpletable";
		List<SimpleDTO> simples = new ArrayList<SimpleDTO>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for (Map<String, Object> row : rows) {
			SimpleDTO dto = new SimpleDTO();
			dto.setName(String.valueOf(row.get("NAME")));
			dto.setSex(String.valueOf(row.get("SEX")));
			dto.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
			dto.setRegDate( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(String.valueOf(row.get("REGDATE"))) );
			simples.add(dto);
		}
		return simples;
	}

	
	public String getName(int id) {
		String sql = "select name from simpletable where id=?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		return name;
	}
}
