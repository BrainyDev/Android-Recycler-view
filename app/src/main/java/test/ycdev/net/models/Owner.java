package test.ycdev.net.models;

/**
 * Created by yassine on 2/5/18.
 */
// This class contains metadata about the repository owner
public class Owner {
    private String login;
    private String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
