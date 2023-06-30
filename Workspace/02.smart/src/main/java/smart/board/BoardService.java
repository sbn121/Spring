package smart.board;

import smart.common.PageVO;

public interface BoardService {
	int board_register(BoardVO vo); // 신규 방명록 글저장
	PageVO board_list(PageVO page); // 방명록 목록 조회(페이지처리)
	BoardVO board_info(int id); // 방명록 글 안내 조회
	int board_update(BoardVO vo); // 방명록 변경저장
	int board_read(int id); // 조회수 증가처리
	int board_delete(int id); // 방명록 글 삭제
}
