package smart.board;

import java.util.List;

import smart.common.PageVO;

public interface BoardService {
	int board_register(BoardVO vo); // 신규 방명록 글저장
	PageVO board_list(PageVO page);	// 방명록 목록 조회(페이지처리)
	BoardVO board_info(int id); 	// 방명록 글 안내 조회
	int board_update(BoardVO vo); 	// 방명록 변경저장
	int board_read(int id); 		// 조회수 증가처리
	int board_delete(int id); 		// 방명록 글 삭제
	
	FileVO board_file_info(int id); // 선택한 파일정보조회
	List<FileVO> board_file_removed(String removed);  //삭제할 파일들 정보 조회
	int board_file_delete(int id); //선택 파일정보 삭제
	
	int board_comment_register(BoardCommentVO vo); // 댓글 신규저장
	int board_comment_update(BoardCommentVO vo);// 댓글 변경저장
	int board_comment_delete(int id);// 댓글 삭제
	List<BoardCommentVO> board_comment_list(int board_id);// 댓글 목록 조회
}
