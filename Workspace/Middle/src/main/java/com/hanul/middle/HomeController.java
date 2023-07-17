package com.hanul.middle;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@RestController	
public class HomeController {
	@Autowired @Qualifier("hanul") SqlSession sql;
	@Autowired @Qualifier("hr") SqlSession sql1;
	@Autowired MiddleDAO dao;
	
	//어노테이션 == 주석?
	//@영어 <= 어노테이션 == 기계가 해석하는 주석.(Tag)
	//@ ctrl+space 누르면 나오는 모든 것을은 어노테이션임. 어노테이션은 밑에 있는 메소드나 또는 변수, 객체 등의 
	//역할을 정해주는 기능을 담당한다.
	//class(어떤 요청을 받기 위한 객체x)
	//@Controller class (어떤 요청을 받는 객체 ==> 컴퓨터 인식(Spring)) org.spring...어노테이션종류
	
	//json / xml
	//json <= String으로 되어있는데 key와 value가 존재하고 list같은 자료구조도 [] 등으로 표현이 가능한 데이터 타입.
	//요소 하나 (Object, DTO)==>기호 : {}, List==> {},
	// [{vo} ... {vo.lastindex}]
	
	@RequestMapping(value="/list.cu", produces = "text/html;charset=utf-8" )
	public String list(String param) {
		System.out.println("누군가다 왔다감"+param);
		List<MiddleVO> list = sql.selectList("middle.list");
//		MiddleVO one = dao.info(vo);
		Gson gson = new Gson();
		//Object(List, DTO등)==> String json으로 바꾸는 메소드 : toJson메소드
		return gson.toJson(list);
	}
	
	@RequestMapping(value="/delete.cu", produces = "text/html;charset=utf-8")
	public String delete(int id) {
		int result = sql.delete("middle.delete", id);
		return result==1 ? "성공" : "실패";
	}
	
	@RequestMapping(value="/insert.cu", produces = "text/html;charset=utf-8")
	public String insert(MiddleVO vo) {
		int result = sql.insert("middle.insert", vo);
		return result==1 ? "성공" : "실패";
	}
	
	@RequestMapping(value="/update.cu", produces = "text/html;charset=utf-8")
	public String update(MiddleVO vo) {
		int result = sql.update("middle.update", vo);
		return result==1 ? "성공" : "실패";
	}
	
	
	@RequestMapping(value="/obj.cu", produces = "text/html;charset=utf-8")
	public String obj() {
		MiddleVO vo = new MiddleVO();
		vo.setEmail("email");
		vo.setName("이름이름");
		return new Gson().toJson(vo);
		}
	
	@RequestMapping(value="/select", produces = "text/html;charset=utf-8")
	public String select() {
		List<EmployeeVO> list = sql1.selectList("middle.select");
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/search", produces = "text/html;charset=utf-8")
	public String search(String str) {
		List<EmployeeVO> list = sql1.selectList("middle.search", str);
		return new Gson().toJson(list);
	}
	
	
//	@Autowired TestBean bean1;
//	TestBean bean2;
//	
//	@RequestMapping("/test.bean")
//	public void test() {
//		System.out.println(bean1);
//		System.out.println(bean2);
//	}
	
}
