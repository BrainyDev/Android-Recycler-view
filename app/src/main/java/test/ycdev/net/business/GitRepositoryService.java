package test.ycdev.net.business;

import java.util.List;

import test.ycdev.net.models.GitRepository;

/**
 * Created by yassine on 2/5/18.
 */

public interface GitRepositoryService {
    public List<GitRepository> getRepositories();
}
