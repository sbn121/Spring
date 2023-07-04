package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customer.CustomerVO;

@RestController
public class CustomerController {
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	// Interface => INterfaceImpl => Dao : 대구묘 프로젝트에서 Spring MVC
	
	@RequestMapping("/one.cu")
	public String one(CustomerVO tempvo) {//<= parameter부. 사용자가 어떤 요청을할 때 데이터를 넘겨주는 부분. (받는 부분)
		//Integer.parseInt(req.getParameter("id"))
		//one<= sql.selectOne (객체 하나, 무조건 row가 하나여야함)
		// 1. id, name값의 파라메터를 가져옴. Controller
		// 2. mapper에 전송
//		CustomerVO tempvo = new CustomerVO();
//		tempvo.setId(id);
//		tempvo.setName(name);
		CustomerVO vo = sql.selectOne("cu.one", tempvo);
		System.out.println(vo.getName());
		return "one";
	}
	@RequestMapping("/list.cu")
	public String list() {
		List<CustomerVO> list = sql.selectList("cu.list");
		System.out.println(list.size());
		return "list";
	}

}
