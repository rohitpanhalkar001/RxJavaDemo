package com.mangomirror.app.rxjavawithretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mangomirror.app.rxjavawithretrofit.Model.PostObject;

import java.util.List;

/**
 * Created by Mindbowser-BA on 22-Aug-18.
 */

public class PostRecyclerView extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<PostObject> postObjectList;

    public PostRecyclerView(Context context, List<PostObject> postObjectList) {
        this.context = context;
        this.postObjectList = postObjectList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {

        holder.txt_Authur.setText(String.valueOf(postObjectList.get(position).getUserId()));
        holder.txt_content.setText(new StringBuilder(postObjectList.get(position).getTitle().substring(0,10)).append("...").toString());
        holder.txt_title.setText(postObjectList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postObjectList.size();
    }
}
