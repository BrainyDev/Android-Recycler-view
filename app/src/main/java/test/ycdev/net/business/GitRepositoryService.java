package test.ycdev.net.business;

import retrofit.Call;
import test.ycdev.net.models.JsonRoot;

/**
 * Created by yassine on 2/5/18.
 */

public interface GitRepositoryService {
    public Call<JsonRoot> getRepositoryList();
}
