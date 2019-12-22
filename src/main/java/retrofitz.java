import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

import java.util.List;

public class retrofitz
{
    public static void main(String[] args)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                //for parsing response
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //retrofit creates and handles the interface methods like getAlbums and getPost
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("postId","5");
        params.put("_sort","id");
        params.put("_order","desc");
        Call<List<Comments>> call = jsonPlaceHolderApi.getComments(params);

        call.enqueue(new Callback<List<Comments>>() {
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful())
                {
                    System.out.println(response.code());
                    return;
                }
                List<Comments> listofComments = response.body();
                for(Comments comments: listofComments)
                {
                    String content = "";
                    content += "ID: " + comments.getCommentID() + "\n";
                    content += "Post ID: " + comments.getPostId() + "\n";
                    content += "Name: " + comments.getName() + "\n";
                    content += "Email: " + comments.getEmail() + "\n";
                    content += "Text: " + comments.getBody() + "\n\n";
                    System.out.println(content);
                }
            }

            public void onFailure(Call<List<Comments>> call, Throwable throwable) {

            }
        });

        Call<Post> createPost = jsonPlaceHolderApi.createPost(new Post(19,"Karan has big code", "nice big code"));
        createPost.enqueue(new Callback<Post>() {
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful())
                {
                    System.out.println(response.code());
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getUserID() + "\n";
                content += "Name: " + postResponse.getTitle()+ "\n";
                content += "Text: " + postResponse.getBody() + "\n\n";
                System.out.println(content);
            }

            public void onFailure(Call<Post> call, Throwable throwable) {

            }
        });
    }
}
