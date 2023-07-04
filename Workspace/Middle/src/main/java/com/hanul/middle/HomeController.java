package com.hanul.middle;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

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


@RestController
public class HomeController {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	@Autowired MiddleDAO dao;
	
	// RestAPI : Page가 필요할 때의 요청이 아니라 데이터가 필요할 때 파라메터를 주고 데이터를 요청함.
	// 대부분 json이나 xml형태로 데이터를 return해준다.
	// json{"key" : "value"}
	// Smart 일반 로그인 : =>
	
	//		V	=>	M	=>	C
	// 요청=>Controller=>Database조회(Model)=>View(Web)
	// Android화면=>요청(Controller)=>Model=>Android화면
	
	//@ResponseBody =>RestController
	@RequestMapping("/")
	public String home(Model model, HttpServletResponse res) throws Exception {
		return "aaa";
//		int i = sql.selectOne("middle.dual");
//		model.addAttribute("i", i);
//		res.getWriter().println(i);//<=syso x <=콘솔이 아니라 페이지에 바로 데이터를 출력하겠다.
		//응답을 하고나서는 다시 응답을 하는 것은 오류라고 인식함. (response가 응답을 이미처리함. page x)
	}
	
//	@RequestMapping(value="/one.cu", produces="text/html; charset=utf-8")
//	public String one() {
//		return sql.selectOne("middle.one");
//	}
//	
//	@RequestMapping(value="/list.cu", produces="text/html; charset=utf-8")
//	public String list() {
//		String list="";
////		int cnt = sql.selectOne("middle.cnt");
//		List<MiddleVO> listVo = sql.selectList("middle.list");
//		for(MiddleVO vo : listVo) {
//			
//			list+=vo.getUserid()+vo.getName()+vo.getGender()+vo.getEmail()+vo.getPhone()+" ";
//		}
//		return list;
//	}
	
}
