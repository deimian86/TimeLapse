package com.deimian86.timelapse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommentAdapter adapter;
    private List<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        commentList = new ArrayList<>();
        adapter = new CommentAdapter(this, commentList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareComments();
    }

    private void prepareComments() {

        Comment c = new Comment();
        c.setAuthorName(getString(R.string.name_1));
        c.setCommentString(getString(R.string.dialog_1));
        c.setCommentDate(daysAgo(14));
        c.setAuthorAvatar(getDrawable(R.drawable.guybrush));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_2));
        c.setCommentString(getString(R.string.dialog_2));
        c.setCommentDate(daysAgo(7));
        c.setAuthorAvatar(getDrawable(R.drawable.lechuck));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_1));
        c.setCommentString(getString(R.string.dialog_3));
        c.setCommentDate(daysAgo(3));
        c.setAuthorAvatar(getDrawable(R.drawable.guybrush));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_2));
        c.setCommentString(getString(R.string.dialog_4));
        c.setCommentDate(daysAgo(1));
        c.setAuthorAvatar(getDrawable(R.drawable.lechuck));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_1));
        c.setCommentString(getString(R.string.dialog_5));
        c.setCommentDate(hoursAgo(3));
        c.setAuthorAvatar(getDrawable(R.drawable.guybrush));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_2));
        c.setCommentString(getString(R.string.dialog_6));
        c.setAuthorAvatar(getDrawable(R.drawable.lechuck));
        c.setCommentDate( hoursAgo(1));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_1));
        c.setCommentString(getString(R.string.dialog_7));
        c.setAuthorAvatar(getDrawable(R.drawable.guybrush));
        c.setCommentDate(minutesAgo(15));
        commentList.add(c);

        c = new Comment();
        c.setAuthorName(getString(R.string.name_2));
        c.setCommentString(getString(R.string.dialog_8));
        c.setAuthorAvatar(getDrawable(R.drawable.lechuck));
        c.setCommentDate(minutesAgo(5));
        commentList.add(c);

        adapter.notifyDataSetChanged();
    }

    private Date daysAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -i);
        return cal.getTime();
    }

    private Date hoursAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -i);
        return cal.getTime();
    }

    private Date minutesAgo(int i) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -i);
        return cal.getTime();
    }
}
