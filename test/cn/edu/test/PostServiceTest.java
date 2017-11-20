package cn.edu.test;

import org.junit.Test;

import cn.edu.domain.Post;
import cn.edu.service.PostService;

public class PostServiceTest extends BaseSpring{
	
	@Test
	public void testPostService(){
		PostService postService = (PostService) applicationContext.getBean("postService");
		Post post = postService.getPostById(1L);
	}
}
