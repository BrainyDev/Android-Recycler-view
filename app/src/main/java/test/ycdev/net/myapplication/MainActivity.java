package test.ycdev.net.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;

import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import test.ycdev.net.business.GitRepositoryService;
import test.ycdev.net.business.GitRepositoryServiceImpl;
import test.ycdev.net.dao.GitRepositoryDao;
import test.ycdev.net.dao.GitRepositoryDaoImpl;
import test.ycdev.net.models.GitRepository;
import test.ycdev.net.models.JsonRoot;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter repoAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<GitRepository> repositories;
    private LinearLayout setting,trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        start();
        test02();
    }

    void start() {
        GitRepositoryDao dao = new GitRepositoryDaoImpl();
        GitRepositoryService business = new GitRepositoryServiceImpl(dao);

        Call<JsonRoot> call = business.getRepositoryList();
        call.enqueue(new Callback<JsonRoot>() {
            @Override
            public void onResponse(Response<JsonRoot> response, Retrofit retrofit) {
                JsonRoot jsonRoot = response.body();
                repositories = jsonRoot.getItems();// load repositories in List

                recyclerView = findViewById(R.id.repositories_recycler_view);
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
                recyclerView.addItemDecoration(dividerItemDecoration);

                repoAdapter = new RepositoryAdapter(repositories);
                recyclerView.setAdapter(repoAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error","MainActivity.test() has encountered an error");
                t.printStackTrace();
            }
        });
    }

    void test02() {
        setting = findViewById(R.id.setting_layout);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Setting (to be continued)", Toast.LENGTH_SHORT).show();
            }
        });

        trending = findViewById(R.id.trending);
        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Trending (to be continued)", Toast.LENGTH_SHORT).show();
            }
        });

    }

}