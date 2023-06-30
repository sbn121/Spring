package smart.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import smart.common.PageVO;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("hanul") private SqlSession sql;

	@Override
	public int board_register(BoardVO vo) {
		return 0;
	}

	@Override
	public PageVO board_list(PageVO page) {
		return null;
	}

	@Override
	public BoardVO board_info(int id) {
		return null;
	}

	@Override
	public int board_update(BoardVO vo) {
		return 0;
	}

	@Override
	public int board_read(int id) {
		return 0;
	}

	@Override
	public int board_delete(int id) {
		return 0;
	}

}
