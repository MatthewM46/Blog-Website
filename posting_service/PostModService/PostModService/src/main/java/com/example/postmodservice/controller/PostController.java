package com.example.postmodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.postmodservice.PostRequestDto;
import com.example.postmodservice.PostResponseDto;
import com.example.postmodservice.CommentRequestDto;
import com.example.postmodservice.CommentResponseDto;
import com.example.postmodservice.ReviewRequestDto;
import com.example.postmodservice.ReviewResponseDto;
import com.example.postmodservice.IncrementResponseDto;
import com.example.postmodservice.ReviewPostResponseDto;


import com.example.postmodservice.controller.PostState;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final PostContext postContext;

    @Autowired
    public PostController(PostService postService, PostContext postContext) {
        this.postService = postService;
        this.postContext = postContext;
    }

    // Hide a post
    @PostMapping("/hide-post")
    public ResponseEntity<PostResponseDto> hidePost(@RequestBody PostRequestDto request) {
        synchronized (postContext) {
            postContext.setPostId(request.getPostId());
            postContext.hide();
        }
        // ... additional logic such as logging
        return ResponseEntity.ok(new PostResponseDto(request.getPostId()));
    }

    // Flag a post
    @PostMapping("/flag-post")
    public ResponseEntity<PostResponseDto> flagPost(@RequestBody PostRequestDto request) {
        synchronized (postContext) {
            postContext.setPostId(request.getPostId());
            postContext.flag();
        }
        // ... additional logic such as logging
        return ResponseEntity.ok(new PostResponseDto(request.getPostId()));
    }

    // Make a post visible
    @PostMapping("/make-post-visible")
    public ResponseEntity<PostResponseDto> makePostVisible(@RequestBody PostRequestDto request) {
        synchronized (postContext) {
            postContext.setPostId(request.getPostId());
            postContext.makeVisible();
        }
        // ... additional logic such as logging
        return ResponseEntity.ok(new PostResponseDto(request.getPostId()));
    }

    // Create a post
    @PostMapping("/create-post")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto request) {
        Post post = postService.createPost(request.getUserId(), request.getContent());
        return ResponseEntity.ok(new PostResponseDto(post.getId()));
    }

    // Add a comment
    @PostMapping("/add-comment")
    public ResponseEntity<CommentResponseDto> addComment(@RequestBody CommentRequestDto request) {
        Comment comment = postService.addComment(request.getPostId(), request.getUserId(), request.getContent());
        return ResponseEntity.ok(new CommentResponseDto(comment.getId()));
    }

    // Get posts
    @PostMapping("/get-posts")
    public ResponseEntity<List<PostResponseDto>> getPosts(@RequestBody PostRequestDto request) {
        List<Post> posts = postService.getPosts(request.getUserId());
        List<PostResponseDto> response = posts.stream()
                .map(post -> new PostResponseDto(post.getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // Get a post for review
    @GetMapping("/moderation/queue")
    public ResponseEntity<ReviewPostResponseDto> getPostForReview() {
        Post post = postService.getPostForReview();
        return ResponseEntity.ok(new ReviewPostResponseDto(post.getId(), post.getContent()));
    }

    // Review a post
    @PostMapping("/posts/{postId}/review")
    public ResponseEntity<ReviewResponseDto> reviewPost(@PathVariable String postId, @RequestBody ReviewRequestDto request) {
        boolean success = postService.reviewPost(postId, request.getDecision(), request.getModeratorId());
        return ResponseEntity.ok(new ReviewResponseDto(success, "Post reviewed successfully"));
    }

    // Increment removed post count
    @PostMapping("/users/{userId}/incrementRemovedPost")
    public ResponseEntity<IncrementResponseDto> incrementRemovedPost(@PathVariable String userId) {
        int count = postService.incrementRemovedPostCount(userId);
        return ResponseEntity.ok(new IncrementResponseDto(true, count));
    }
}
