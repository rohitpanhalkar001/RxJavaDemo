package com.mangomirror.app.rxjavawithretrofit;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mangomirror.app.rxjavawithretrofit.Model.myInterface.Crypto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindbowser-BA on 22-Aug-18.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView txt_title,txt_content, txt_Authur;

    public PostViewHolder(View itemView) {
        super(itemView);

        txt_title = (TextView) itemView.findViewById(R.id.titleTv);
        txt_content = (TextView) itemView.findViewById(R.id.contentTv);
        txt_Authur = (TextView) itemView.findViewById(R.id.authurTv);

    }
}