package repository;

import java.util.*;
import com.example.postmodservice.controller.Comment;
import com.example.postmodservice.controller.Post;

public class CommentRepository {

    ArrayList<Comment> db;

    public CommentRepository() {
        this.db = new ArrayList<>();
    }

    public Comment save(Comment c) {
        if (c != null) {
            db.add(c);
        } else {
            System.out.println("Invalid Comment!\n");
        } return c;
    }



}
