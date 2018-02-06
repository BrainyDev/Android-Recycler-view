package test.ycdev.net.dao;

import android.util.Log;


import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import test.ycdev.net.models.JsonRoot;

import static android.content.ContentValues.TAG;


/**
 * Created by yassine on 2/5/18.
 */

public class GitRepositoryDaoImpl implements GitRepositoryDao {
    private String url = "https://api.github.com/";

    @Override
    public Call<JsonRoot> loadJSONData() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitRepositoryDao gitRepositoryDao = retrofit.create(GitRepositoryDao.class);
            Call<JsonRoot> call = gitRepositoryDao.loadJSONData();
            return call;
        } catch (Exception e) {
            Log.e(TAG, "GitRepositoryDaoImpl.loadJSONData() has encountered an error : " + e.getMessage());
            return null;
        }
    }

}
