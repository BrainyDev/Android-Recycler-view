package test.ycdev.net.dao;

import retrofit.Call;
import retrofit.http.GET;
import test.ycdev.net.models.JsonRoot;

public interface GitRepositoryDao {
    String suffix = "search/repositories?q=created:>2017-10-22&sort=stars&order=desc";

    @GET(suffix)
    public Call<JsonRoot> loadJSONData();
}
