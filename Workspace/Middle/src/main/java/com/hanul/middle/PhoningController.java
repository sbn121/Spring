package com.hanul.middle;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController @RequestMapping("/phoning")
public class PhoningController {
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	@RequestMapping(value="/checkEmail", produces = "text/html;charset=utf-8")
	public String checkEmail(String email) {
		PhoningVO vo = sql.selectOne("phoning.checkEmail", email);
		return new Gson().toJson(vo);
	}
}
