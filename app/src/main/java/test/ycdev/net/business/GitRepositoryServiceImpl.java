package test.ycdev.net.business;

import java.util.List;

import test.ycdev.net.dao.GitRepositoryDao;
import test.ycdev.net.models.GitRepository;

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
    public List<GitRepository> getRepositories() {
        return dao.getJSONRepositories();
    }
}
