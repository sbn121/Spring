package kr.co.smart;

import java.sql.Connection;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import smart.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	
	@Autowired private DataSource dbcpHanul;
	
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void login() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("로그인할 아이디 : ");
		String userid = scan.next();

		System.out.print("로그인할 비밀번호 : ");
		String userpw = scan.next();
		
		MemberVO vo = sql.selectOne("member.loginTest", userid);
		if(vo==null) {
			System.out.println("아이디가 없음!!");
		}else {
			boolean match = passwordEncoder.matches(userpw, vo.getUserpw());
			if(match) {
				System.out.println(vo.getName()+"로그인됨");
			}else {
				System.out.println("비밀번호가 안 맞음!!");
			}
		}
		scan.close();
	}
	
	@Test
	public void join() {
		// 키보드로 입력받을 정보 : 이름, 아이디, 비번, 이메일
		Scanner scan = new Scanner(System.in);
		MemberVO vo = new MemberVO();
		System.out.print("이름 : ");
		vo.setName(scan.next());
		
		System.out.print("아이디 : ");
		vo.setUserid(scan.next());
		
		System.out.print("비밀번호 : ");
		vo.setUserpw(passwordEncoder.encode(scan.next()));
		
		System.out.print("이메일 : ");
		vo.setEmail(scan.next());
		
		System.out.print("관리자여부(y/n) : ");
		vo.setAdmin(scan.next().toUpperCase());
		
		//DML(Data Manipulation Language) : select, insert, update, delete
		//Query L : select
		//DML : insert, update, delete
		int dml = sql.insert("member.joinTest", vo);
		System.out.println(dml == 1 ? "가입 성공" : "가입 실패");
		scan.close();
	}
//	
//	@Test
//	public void today() {
//		String today = sql.selectOne("test.today");
//		System.out.println("오늘은 "+today);
//	}
	
//	@Test
//	public void connect() throws Exception {
//		Connection conn = null;
//		try {
//			conn = ds.getConnection();
//			System.out.println("DB 연결 성공 : "+conn);
//		}catch (Exception e) {
//			System.out.println("DB 연결 실패");
//		}finally {
//			conn.close();
//			System.out.println();
//		}
//	}
}
