package test.ycdev.net.dao;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import test.ycdev.net.models.GitRepository;
import test.ycdev.net.models.JsonRoot;


/**
 * Created by yassine on 2/5/18.
 */

public class GitRepositoryDaoImpl implements GitRepositoryDao {
    private String url = "https://api.github.com/";
    private List<GitRepository> repositories;

    public List<GitRepository> getRepositories() {
        return repositories;
    }

    @Override
    public Call<JsonRoot> loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitRepositoryDao gitRepositoryDao = retrofit.create(GitRepositoryDao.class);
        Call<JsonRoot> call = gitRepositoryDao.loadData();

        call.enqueue(new Callback<JsonRoot>() {
            @Override
            public void onResponse(Response<JsonRoot> response, Retrofit retrofit) {
                JsonRoot jsonRoot = response.body();
                repositories = jsonRoot.getItems();// load repositories in List
                for (GitRepository repo : repositories) {
                    Log.d("Repository name", repo.getName()+"");
                    Log.d("Repository description", repo.getDescription()+"");
                    Log.d("Owner login", repo.getOwner().getLogin()+"");
                    Log.d("Owner avatar", repo.getOwner().getAvatar_url()+"");
                    Log.d("Repository stars", String.valueOf(repo.getStars())+"");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error","GitRepositoryServiceImpl.loadData() has encountered an error");
                t.printStackTrace();
            }
        });
        return call;
    }

    @Override
    public List<GitRepository> getJSONRepositories() {
        loadData();
        return repositories;
    }
}
