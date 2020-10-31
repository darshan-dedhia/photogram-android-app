package com.codepath.darshandedhia.photogram.Fragments;

import android.util.Log;

import com.codepath.darshandedhia.photogram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error occured while fetching all posts");
                } else {
                    Log.i(TAG, "Fetching all posts successful");
                    for (Post post : objects) {
                        Log.i(TAG, post.getDescription());
                    }
                    posts.addAll(objects);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
