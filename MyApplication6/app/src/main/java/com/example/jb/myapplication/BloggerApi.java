package com.example.jb.myapplication;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerApi  {

    private static final String key="AIzaSyCjxqANGAdNb8x2Eo0VU7q_QtySLTNdPuM";
    private static final String url="https://www.googleapis.com/blogger/v3/blogs/2015733786679474384/posts/";
    public static PostService postService= null;

    public static PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService =retrofit.create(PostService.class);
        }
        return postService;
    }
    public interface PostService
    {
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }
}
