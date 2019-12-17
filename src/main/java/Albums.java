import com.google.gson.annotations.SerializedName;

public class Albums
{
    @SerializedName("userId")
    private int albumUserID;

    @SerializedName("id")
    private int albumID;

    @SerializedName("title")
    private String albumtitle;

    public int getAlbumUserID() {
        return albumUserID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public String getAlbumtitle() {
        return albumtitle;
    }
}
