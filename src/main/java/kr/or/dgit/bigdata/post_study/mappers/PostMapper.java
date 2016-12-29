package kr.or.dgit.bigdata.post_study.mappers;

import java.util.List;

import kr.or.dgit.bigdata.post_study.dto.Post;

public interface PostMapper {
	public List<Post> selectBySidoro(String sido, String doro);
	public List<String> getSido();
	
}
