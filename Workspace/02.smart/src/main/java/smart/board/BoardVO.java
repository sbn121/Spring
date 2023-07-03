package smart.board;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardVO {
	private int id, readcnt, no, filecnt;
	private String title, content, writer, name;
	private Date writerdate;
	private List<FileVO> fileList; 
}
