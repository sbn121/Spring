package retrofit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class RetrofitDAO {
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	public List<CRUDRetrofitVO> select(){
		return sql.selectList("retrofit.select");
	}
	
	public int insert(CRUDRetrofitVO vo){
		return sql.selectOne("retrofit.insert", vo);
	}
	
	public int update(CRUDRetrofitVO vo){
		return sql.selectOne("retrofit.update", vo);
	}
	
	public int delete(CRUDRetrofitVO vo){
		return sql.selectOne("retrofit.delete", vo);
	}
}
