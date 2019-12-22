import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface JsonPlaceHolderApi
{
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("albums")
    Call<List<Albums>> getAlbums();

    @GET("comments")
    Call<List<Comments>> getComments(@QueryMap HashMap<String,String> params);

    @GET("posts")
    Call<List<Post>> getUserPosts(@Query("userId") int userID);

    @POST("posts")
    Call<Post> createPost(@Body Post posts);
}
