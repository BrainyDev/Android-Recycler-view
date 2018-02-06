package test.ycdev.net.models;

/**
 * Created by yassine on 2/5/18.
 */

public class GitRepository {

    private String name;
    private String description;
    private Owner owner;
    private int stargazers_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getStars() {
        return stargazers_count;
    }

    public void setStars(int stars) {
        this.stargazers_count = stargazers_count;
    }

}