package com.example.forumbackend.service;

import com.example.forumbackend.domain.Post;

import java.util.List;

public interface PostService {
    /**
     * 获取帖子列表
     * @return
     */
    List<Post> getPostList();

    /**
     * 通过id获取帖子
     * @param id 帖子id
     * @return
     */
    Post getPostById(Integer id);

    /**
     * 提交帖子
     * @param post
     * @return
     */
    Post submit(Post post);

    /**
     * 批量删除
     * @param ids id列表
     * @return
     */
    Integer deleteBatch(List<Integer> ids);
}
