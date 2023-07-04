package com.hanul.middle;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository
public class MiddleDAO {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	public List<MiddleVO> list(){
		return sql.selectList("middle.list");
	};

}
