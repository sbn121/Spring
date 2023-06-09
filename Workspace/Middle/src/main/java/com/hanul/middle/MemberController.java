package com.hanul.middle;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController @RequestMapping("/member")
public class MemberController {
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	@RequestMapping(value="/login", produces = "text/html;charset=utf-8")
	public String login(MemberVO vo) {
			MemberVO info = sql.selectOne("middle.info", vo);
			return new Gson().toJson(info);
	}

}
