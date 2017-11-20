package cn.edu.service;

import java.io.Serializable;
import java.util.Collection;

import cn.edu.domain.Post;

public interface PostService {
	public void savePost(Post post);
	public void deletePostById(Serializable id);
	public void updatePost(Post post);
	public Post getPostById(Serializable id);
	public Collection<Post> getAllPost();
}
