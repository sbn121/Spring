package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	@RequestMapping("/one.nt")
	public String one(NoticeVO vo) {
		NoticeVO nvo = sql.selectOne("notice.one", vo);
		return nvo.getTitle();
	}
	@RequestMapping("/list.nt")
	public String list() {
		List<NoticeVO> list = sql.selectList("notice.list");
		System.out.println(list.get(0).getContent());
		return "";
	}

}
