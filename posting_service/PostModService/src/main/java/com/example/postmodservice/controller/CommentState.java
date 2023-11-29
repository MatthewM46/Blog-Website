package com.example.postmodservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.postmodservice.controller.CommentContext;

// Comment State interface
public interface CommentState {
    void hide(CommentContext context);
    void flag(CommentContext context);
    void makeVisible(CommentContext context);
}

// Concrete Comment States
@Component
class CommentVisibleState implements CommentState {
    @Override
    public void hide(CommentContext context) {
        context.setState((CommentState) context.getCommentHiddenState());
    }

    @Override
    public void flag(CommentContext context) {
        context.setState((CommentState) context.getCommentFlaggedState());
    }

    @Override
    public void makeVisible(CommentContext context) {
        // Comment is already visible
    }
}

@Component
class CommentHiddenState implements CommentState {
    @Override
    public void hide(CommentContext context) {
        // Comment is already hidden
    }

    @Override
    public void flag(CommentContext context) {
        context.setState((CommentState) context.getCommentFlaggedState());
    }

    @Override
    public void makeVisible(CommentContext context) {
        context.setState((CommentState) context.getCommentVisibleState());
    }
}

@Component
class CommentFlaggedState implements CommentState {
    @Override
    public void hide(CommentContext context) {
        context.setState((CommentState) context.getCommentHiddenState());
    }

    @Override
    public void flag(CommentContext context) {
        // Comment is already flagged
    }

    @Override
    public void makeVisible(CommentContext context) {
        context.setState((CommentState) context.getCommentVisibleState());
    }
}
