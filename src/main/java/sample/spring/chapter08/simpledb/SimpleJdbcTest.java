package sample.spring.chapter08.simpledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SimpleJdbcTest {
	private static Logger logger = LoggerFactory.getLogger(SimpleJdbcTest.class);
	
	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter08_database.xml");
//		component-scan 으로  객체 가져오기 
		SimpleService simpleService  = context.getBean(SimpleService.class);
		
		SimpleJdbcTest jdbcTest = new SimpleJdbcTest();
		
		SimpleDTO simpleDTO = new SimpleDTO();
		simpleDTO.setName("러블리즈");
		simpleDTO.setAge(15);
		simpleDTO.setSex("F");
		simpleDTO.setRegDate(new Date());
		
//		jdbcTemplateInsert insert
		jdbcTest.use_JdbcTemplateInsert(simpleService,simpleDTO);
		
//		jdbcTemplate insert
		jdbcTest.use_JdbcTemplate(simpleService,simpleDTO);
		
//		jdbcTemplate get one
		jdbcTest.jdbcTemplateRowMapper(simpleService, 3);
		
//		jdbcTemplate get all
		jdbcTest.use_TemplateGetAll(simpleService);
		
//		jdbcTemplate single column
		jdbcTest.use_TemplateSingleColumn(simpleService,12);
	
//		jdbc get All
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		jdbcTest.getRawQuery(dataSource, 10);


	}

	public void use_JdbcTemplateInsert(SimpleService simpleService,SimpleDTO simpleDTO) {
		
		int result = simpleService.insertData(simpleDTO);
		logger.info("use_JdbcTemplateInsert: "+result);
	}
	
//	jdbcTemplate raw query 사용
	public void use_JdbcTemplate(SimpleService simpleService,SimpleDTO simpleDTO) {
		
		int result = simpleService.use_JdbcTemplate(simpleDTO);
		logger.info("use_JdbcTemplate: "+result);
	}
	
	
//	JdbcTemplate 사용
	public void jdbcTemplateRowMapper(SimpleService simpleService, int id) {
		SimpleDTO getDTO =simpleService.getDataSingle(id);
		logger.info("jdbcTemplateRowMapper: "+getDTO.toString());
	}
	
	public void use_TemplateGetAll(SimpleService simpleService) throws ParseException {
		List<SimpleDTO> simples = simpleService.findAll();
		for (SimpleDTO simpleDTO : simples) {
			logger.info("use_TemplateGetAll: "+simpleDTO.toString());
		}
	}
	
//	JdbcTemplate 사용
	public void use_TemplateSingleColumn(SimpleService simpleService, int id) {
		String name =simpleService.getName(id);
		logger.info("use_TemplateSingleColumn: "+name);
	}
	
	
//	raw query
	public void getRawQuery(DataSource dataSource, int id) {
		 
		String sql = "select * from simpletable WHERE ID = ?";
 
		Connection conn = null;
		SimpleDTO dto = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new SimpleDTO(rs.getString("name"), rs.getString("sex"),rs.getInt("age"), rs.getDate("regDate")) ;
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
			
			logger.info("getRawQuery: "+dto.toString());
		}
	}
	
	
	

}
