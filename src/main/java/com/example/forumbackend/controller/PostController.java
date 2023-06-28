package com.example.forumbackend.controller;

import com.example.forumbackend.domain.Post;
import com.example.forumbackend.service.PostService;
import com.example.forumbackend.utils.Result;
import com.example.forumbackend.utils.idList;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @GetMapping("/findPostById")
    public Result<Post> findPostByIdController(Integer id) {
        Post post = postService.getPostById(id);
        if(post != null) {
            return Result.success(post, "查找成功");
        } else {
            return Result.error(3, "未找到该帖子");
        }
    }

    @PostMapping("/getPostList")
    public Result<List<Post>> getPostListController() {
        List<Post> postList = postService.getPostList();
        if(postList == null || postList.size() == 0) {
            return Result.error(3, "目前没有帖子数据，请先去发帖");
        }
        else {
            return Result.success(postList);
        }
    }

    @PostMapping("/submit")
    public Result<Post> submitController(@RequestBody Post newpost) {
        Post post = postService.submit(newpost);
        if(post == null) {
            return Result.error(3, "发布失败");
        }
        else {
            return Result.success(post, "发布成功");
        }
    }

    @PostMapping("/delete")
    public Result<Integer> delete(@RequestBody idList idList) {
        List<Integer> ids = idList.getIds();
        System.out.println(ids);
        Integer cnt = postService.deleteBatch(ids);
        System.out.println(cnt);
        if(cnt == 0) {
            return Result.error(3, "删除失败");
        }
        else {
            return Result.success(cnt, "删除成功");
        }
    }
}
