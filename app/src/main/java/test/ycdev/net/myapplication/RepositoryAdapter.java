package test.ycdev.net.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.ycdev.net.models.GitRepository;

/**
 * Created by yassine on 2/5/18.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    private List<GitRepository> repositories;

    public RepositoryAdapter(List<GitRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View repoView = inflater.inflate(R.layout.repository_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(repoView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String repositoryName = repositories.get(position).getName();
        String repositoryDescription = repositories.get(position).getDescription();
        String avatar_url = repositories.get(position).getOwner().getAvatar_url();
        String repoOwnerName = repositories.get(position).getOwner().getLogin();
        int starsCount = repositories.get(position).getStars();

        holder.repoName.setText(repositoryName);
        holder.repoDescription.setText(repositoryDescription);
        // It let us to display a remote image inside an ImageView : YcDev
        Picasso.with(holder.ownerAvatar.getContext()).load(avatar_url).into(holder.ownerAvatar);
        holder.ownerName.setText(repoOwnerName);
        if (starsCount % 1000 != 0) {
            int result = starsCount / 1000;
            holder.starsNumber.setText(String.valueOf(result) + "k");
        }
        else
            holder.starsNumber.setText(String.valueOf(starsCount));

    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    // Inner class for holding views
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView repoName;
        public TextView repoDescription;
        public ImageView ownerAvatar;
        public TextView ownerName;
        public TextView starsNumber;
        public View layout;

        public ViewHolder(View view) {
            super(view);
            layout = view;
            repoName = view.findViewById(R.id.repo_name);
            repoDescription = view.findViewById(R.id.repo_description);
            ownerAvatar = view.findViewById(R.id.avatar);
            ownerName = view.findViewById(R.id.owner_name);
            starsNumber = view.findViewById(R.id.star_number);
        }
    }
}
