package com.example.happypets.Retrofit;

import com.example.happypets.Model.*;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import java.util.*;
public interface APICall {

    // to register a user
    @POST("/register/user")
    @Multipart
    Call<String> registerUser(@Part MultipartBody.Part image, @Part("user") User user);

    // to login user
    @POST("/login/user")
    Call<String> loginUser(@Body Login login);

    @GET("/get/user/{userId}")
    Call<User> getLoggedInUser(@Path("userId") String userId);

    // to post a pet
    @POST("/post/pet/{userId}")
    @Multipart
    Call<String>postAPet(@Path("userId") String userId,@Part MultipartBody.Part image,@Part("pet") Pet pet );

    //to get all posted pets
    @GET("/get/all/posted/pets/")
    Call<List<Pet>>getAllPostedPet();


   // to get pets by category
    @GET("get/pets/category/{num}")
    Call<List<Pet>>getPetByCategory(@Path("num") int num);


}
