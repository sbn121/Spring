package retrofit;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController @RequestMapping("/retrofit")
public class RetrofitController {

	@Autowired @Qualifier("hanul") SqlSession sql;
	@Autowired RetrofitDAO dao;
	
	@RequestMapping("/list")
	public String list() {
		return new Gson().toJson(dao.select());
	}
	
	@RequestMapping("/insert")
	public String insert(CRUDRetrofitVO vo) {
		return new Gson().toJson(dao.insert(vo));
	}
	@RequestMapping("/update")
	public String update(CRUDRetrofitVO vo) {
		return new Gson().toJson(dao.update(vo));
	}
	@RequestMapping("/delete")
	public String delete(CRUDRetrofitVO vo) {
		return new Gson().toJson(dao.delete(vo));
	}
}
