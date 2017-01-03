package kr.or.dgit.bigdata.post_study;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.post_study.dto.Post;
import kr.or.dgit.bigdata.post_study.service.PostService;

public class PostServiceTest {
	private static PostService postService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		postService = postService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		postService = null;
	}

	@Test
	public void testSelectBySidoro() {
		List<Post> list = postService.selectBySidoro("경상북도", "선기로%");
		Assert.assertNotNull(list);
		for(Post p : list){
			System.out.println(p);
		}
	}

	@Test
	public void testGetSido(){
		List<String> list = postService.getSido();
		Assert.assertNotNull(list);
		for(String s : list){
			System.out.println(s);
		}
	}
}
