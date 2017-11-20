package cn.edu.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dao.PostDao;
import cn.edu.domain.Post;
import cn.edu.service.PostService;
@Service("postService")
public class PostServiceImpl implements PostService {
	
	@Resource(name="postDao")
	private PostDao postDao;
	
	@Transactional(readOnly=false)
	public void savePost(Post post) {
		postDao.saveEntry(post);
	}
	
	@Transactional(readOnly=false)
	public void deletePostById(Serializable id) {
		postDao.deleteEntryById(id);
	}
	
	@Transactional(readOnly=false)
	public void updatePost(Post post) {
		postDao.updateEntry(post);
	}
	
	@Transactional(readOnly=false)
	public Post getPostById(Serializable id) {
		Post post = (Post) postDao.getEntryById(id);
		return post;
	}

	public Collection<Post> getAllPost() {
		Collection<Post> allEntry = postDao.getAllEntry();
		return allEntry;
	}

}
