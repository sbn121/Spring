package kr.co.smart;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	
	@Autowired private DataSource ds;
	
	@Autowired private SqlSession sql;
//	
//	@Test
//	public void today() {
//		String today = sql.selectOne("test.today");
//		System.out.println("오늘은 "+today);
//	}
	
	@Test
	public void connect() throws Exception {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("DB 연결 성공 : "+conn);
		}catch (Exception e) {
			System.out.println("DB 연결 실패");
		}finally {
			conn.close();
			System.out.println();
		}
	}
}
