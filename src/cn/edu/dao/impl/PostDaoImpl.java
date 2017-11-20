package cn.edu.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.dao.PostDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Post;
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao<Post> {
	
}
