package com.example.forumbackend.mapper;

import com.example.forumbackend.domain.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostDao{
    @Select("select * from post where id = #{id}")
    Post findById(Integer id);

    @Select("select * from post")
    List<Post> findAll();

    @Insert("insert into post(uid,username,time,title,content) " +
            "VALUES (" +
            "#{uid}," +
            "#{username}," +
            "#{time}," +
            "#{title}," +
            "#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Post post);

    @Delete("<script>" +
            "delete from post where id in " +
            "<foreach collection='array' open='(' item='id' separator=',' close=')'> #{id}" +
            "</foreach>" +
            "</script>")
    Integer batchDelete(long[] ids);
}
