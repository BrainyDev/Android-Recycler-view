package test.ycdev.net.dao;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import test.ycdev.net.models.GitRepository;
import test.ycdev.net.models.JsonRoot;

/**
 * Created by yassine on 2/5/18.
 */

public interface GitRepositoryDao {
    String suffix = "search/repositories?q=created:>2017-10-22&sort=stars&order=desc";

    @GET(suffix)
    public Call<JsonRoot> loadData();
    public List<GitRepository> getJSONRepositories();
}
