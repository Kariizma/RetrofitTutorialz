import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class retrofitz
{
    public static void main(String[] args)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        Call<List<Albums>> albumcall = jsonPlaceHolderApi.getAlbums();

        albumcall.enqueue(new Callback<List<Albums>>() {
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response)
            {
                if(!response.isSuccessful())
                {
                    System.out.println(response.code());
                    return;
                }

                List<Albums> album = response.body();

                for(Albums albums: album)
                {
                    String content = "";
                    content += "AlbumID: " + albums.getAlbumID() + "\n";
                    content += "AlbumUserID: " + albums.getAlbumUserID() + "\n";
                    content += "AlbumTitle: " + albums.getAlbumtitle() + "\n\n";
                    System.out.println(content);
                }
            }

            public void onFailure(Call<List<Albums>> call, Throwable throwable)
            {
                System.out.println(throwable.getMessage());

            }
        });
    }
}
