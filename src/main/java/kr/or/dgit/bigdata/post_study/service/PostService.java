package kr.or.dgit.bigdata.post_study.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

import kr.or.dgit.bigdata.post_study.dto.Post;
import kr.or.dgit.bigdata.post_study.mappers.PostMapper;
import kr.or.dgit.bigdata.post_study.util.MybatisSqlSessionFactory;

public class PostService {
	private static final Logger logger = Logger.getLogger(PostService.class);

	private static final PostService instance = new PostService();

	public static PostService getInstance() {
		return instance;
	}

	private PostService() {}
	
	public List<Post> selectBySidoro(String sido, String doro){
		if (logger.isDebugEnabled()) {
			logger.debug("selectBySidoro(String, String) - start");
		}
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
		try{
			List<Post> returnList = postMapper.selectBySidoro(sido, doro);
			if (logger.isDebugEnabled()) {
				logger.debug("selectBySidoro(String, String) - end");
			}
			return returnList;
		}finally{
			sqlSession.close();
		}		
	}
	
	public List<String> getSido(){
		if (logger.isDebugEnabled()) {
			logger.debug("getSido() - start");
		}
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
		try{
			List<String> returnList = postMapper.getSido();
			if (logger.isDebugEnabled()) {
				logger.debug("getSido() - end");
			}
			return returnList;
		}finally{
			sqlSession.close();
		}		
	}
}
