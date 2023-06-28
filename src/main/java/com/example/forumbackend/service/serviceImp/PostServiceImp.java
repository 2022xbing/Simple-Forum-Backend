package com.example.forumbackend.service.serviceImp;

import com.example.forumbackend.domain.Post;
import com.example.forumbackend.mapper.PostDao;
import com.example.forumbackend.mapper.UserDao;
import com.example.forumbackend.service.PostService;
import jakarta.annotation.Resource;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
public class PostServiceImp implements PostService {
    @Resource
    private PostDao postDao;

    @Override
    public List<Post> getPostList() {
        return postDao.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        return postDao.findById(id);
    }

    @Override
    public Post submit(Post post) {
        postDao.save(post);
        return post;
    }

    @Override
    public Integer deleteBatch(List<Integer> ids) {
        long[] new_ids = ids.stream().mapToLong(i -> i).toArray();
        System.out.println(Arrays.toString(new_ids));
        return postDao.batchDelete(new_ids);
    }
}
