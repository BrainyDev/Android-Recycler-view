package test.ycdev.net.models;

import java.util.List;

/**
 * Created by yassine on 2/5/18.
 */

public class JsonRoot {
    private List<GitRepository> items;

    public List<GitRepository> getItems() {
        return items;
    }

    public void setItems(List<GitRepository> items) {
        this.items = items;
    }
}
