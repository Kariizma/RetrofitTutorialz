import com.google.gson.annotations.SerializedName;

public class Post
{
    private int userID;

    @SerializedName("id")
    private Integer postID;

    private String title;
    private String body;

    public Post(int userID, String title, String body)
    {
        this.userID = userID;
        this.title = title;
        this.body = body;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
