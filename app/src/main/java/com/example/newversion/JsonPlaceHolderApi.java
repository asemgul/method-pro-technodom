package com.example.newversion;

//import org.w3c.dom.Comment;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

//    @GET("users")
//    Call<List<User>> getPosts(@Query("userId") int userId);// here we can send arrays and etc.

//    @GET("posts/{id}/comments")
//    Call<List<Comment>>getComments(@Path("id") int postId);

//    @POST("posts")
//    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("users")
    Call<User> createPost( //return call object
                           //@Field("userId") int userId,
                           //@Field("title") String title,
                           @Field("phone") long phone,
                           @Field("password") String password,
                           @Field("newPassword") String newPassword
                           //@Field("body") String text
    );
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost(@FieldMap Map<String, String> fields);
//
//    @PUT("posts/{id}")
//    Call<Post> putPost (@Path("id") int id, @Body Post post);
//
//    @PATCH("posts/{id}")
//    Call<Post> patchPost (@Path("id") int id, @Body Post post);


}
