package test.ycdev.net.business;

import retrofit.Call;
import test.ycdev.net.dao.GitRepositoryDao;
import test.ycdev.net.models.JsonRoot;

/**
 * Created by yassine on 2/5/18.
 */

public class GitRepositoryServiceImpl implements GitRepositoryService{

    private GitRepositoryDao dao;

    public GitRepositoryServiceImpl(GitRepositoryDao dao) {
        this.dao = dao;
    }

    public void setDao(GitRepositoryDao dao) {
        this.dao = dao;
    }

    @Override
    public Call<JsonRoot> getRepositoryList() {
        return dao.loadJSONData();
    }
}
