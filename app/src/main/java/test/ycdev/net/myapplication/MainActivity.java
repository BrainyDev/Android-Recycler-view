package test.ycdev.net.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import test.ycdev.net.business.GitRepositoryService;
import test.ycdev.net.business.GitRepositoryServiceImpl;
import test.ycdev.net.dao.GitRepositoryDao;
import test.ycdev.net.dao.GitRepositoryDaoImpl;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    void test() {
        GitRepositoryDao dao = new GitRepositoryDaoImpl();
        GitRepositoryService business = new GitRepositoryServiceImpl(dao);
        business.getRepositories();
        //GitRepositoryDao service = new GitRepositoryServiceImpl(getApplicationContext());

        //service.loadData();
    }

    // By YcDev
    public class DefaultOnClickListener implements View.OnClickListener{
        private Context context;

        public DefaultOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Implementation made by YcDev", LENGTH_SHORT).show();
        }
    }

}
