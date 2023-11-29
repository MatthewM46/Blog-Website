package repository;

import java.util.*;
import com.example.postmodservice.controller.Post;

public class PostRepository {
    List<Post> db;                                   /* Mock Database */

    public PostRepository() {                        // Initializer
        this.db = new ArrayList<>();
    }

    public Post save(Post p) {                       // Saves post to database
        if (p != null) {
            db.add(p);
        } else {
            System.out.println("Invalid Post!\n");
        } return p;
    }

    public List<Post> findAll(String userID) {       // Returns lists of posts based on given user ID
        List<Post> lo_posts = new ArrayList<>();

        for (Post p: db) {
            if (p.getUserId().equals(userID)) {
                lo_posts.add(p);
            }
        } return lo_posts;
    }

    public Optional<Post> findById(String postID) {  // Returns post based on its post ID
        Optional<Post> post = Optional.empty();

        for (Post p: db) {
            if (p.getId().equals(postID)) {
                post = Optional.of(p);
            }
        } return post;
    }

    public Optional<Post> findByFlaggedForReview() {  // Returns first flagged post
        Optional<Post> post = Optional.empty();

        for (Post p: db) {
            if (p.isFlagged()) {
                post = Optional.of(p);
            }
        } return post;
    }



}

