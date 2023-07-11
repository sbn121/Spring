package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController @RequestMapping("/member")
public class MemberController {
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	@Autowired AndMemberDAO dao;
	
	@RequestMapping(value="/logins", produces = "text/html;charset=utf-8")
	public String login(String id, String pw) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("password", pw);
		AndMemberVO vo = dao.login(params);
			return new Gson().toJson(vo);
	}

}
