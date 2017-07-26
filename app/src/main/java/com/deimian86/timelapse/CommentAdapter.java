package com.deimian86.timelapse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Adapter for RecyclerView
 * Created by deimian86 on 24/07/2017.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private Context mContext;
    private List<Comment> commentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView authorName, commentDate, commentText;
        public ImageView authorAvatar;

        public MyViewHolder(View view) {
            super(view);
            authorName = view.findViewById(R.id.cardview_author_name);
            commentDate = view.findViewById(R.id.cardview_date);
            commentText = view.findViewById(R.id.cardview_text);
            authorAvatar = view.findViewById(R.id.cardview_author_avatar);
        }
    }

    public CommentAdapter(Context mContext, List<Comment> commentList) {
        this.mContext = mContext;
        this.commentList = commentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.authorName.setText(comment.getAuthorName());
        holder.authorAvatar.setImageDrawable(comment.getAuthorAvatar());
        holder.commentText.setText(comment.getCommentString());

        String txt = TimeLapse.with(mContext).date(comment.getCommentDate()).locale(Locale.ENGLISH).getLapse();
        holder.commentDate.setText(txt);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
