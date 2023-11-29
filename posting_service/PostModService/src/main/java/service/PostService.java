package service;

import com.example.postmodservice.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import dto.PostRequestDto;
import dto.PostResponseDto;
import dto.CommentRequestDto;
import dto.CommentResponseDto;
import dto.ReviewRequestDto;
import dto.ReviewResponseDto;
import dto.IncrementResponseDto;
import dto.ReviewPostResponseDto;
import dto.PostCreateRequest;
import dto.CommentCreateRequest;
import service.PostService;
import com.example.postmodservice.controller.Post;
import com.example.postmodservice.controller.PostState;
import com.example.postmodservice.controller.PostContext;
import com.example.postmodservice.controller.CommentState;
import com.example.postmodservice.controller.CommentContext;
import repository.CommentRepository;
import repository.PostRepository;


import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VisibleState visibleState;
    @Autowired
    private HiddenState hiddenState;
    @Autowired
    private FlaggedState flaggedState;

    public Post createPost(PostCreateRequest request) {
        // Assuming PostCreateRequest has userId and content
        Post post = new Post();
        post.setUserId(request.getUserId());
        post.setContent(request.getContent());
        PostContext context = new PostContext(visibleState, hiddenState, flaggedState);
        post.setPostContext(context);
        post.setVisible(true);
        return postRepository.save(post);
    }
    public Comment createComment(String postId, CommentCreateRequest request) {
        validateRequest(request.getUserId(), request.getContent());
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setUserId(request.getUserId());
        CommentContext context = new CommentContext(visibleState, hiddenState, flaggedState);
        comment.setCommentContext(context);
        comment.setVisible(true);
        return commentRepository.save(comment);
    }

    private void validateRequest(String userId, String content) {
        if (!StringUtils.hasText(userId)) {
            throw new IllegalArgumentException("User ID cannot be blank");
        }
        if (!StringUtils.hasText(content)) {
            throw new IllegalArgumentException("Content cannot be blank");
        }
    }
    public Comment addComment(String postId, String userId, String content) {
        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setUserId(userId);
        comment.setContent(content);
        CommentContext context = new CommentContext(visibleState, hiddenState, flaggedState);
        comment.setCommentContext(context);
        comment.setVisible(true);

        return commentRepository.save(comment);
    }

    public List<Post> getPosts(String userID) {
        return postRepository.findAll(userID);
    }

    public Optional<Post> getPostForReview() {
        return postRepository.findByFlaggedForReview();
    }

    public boolean reviewPost(String postId, String decision, String moderatorId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            PostContext context = new PostContext(post.getVisibleState(), post.getHiddenState(), post.getFlaggedState());
            context.setPostId(postId);

            // Update the post status based on the decision
            if ("approve".equals(decision)) {
                context.makeVisible(); // Make the post visible if approved
            } else if ("reject".equals(decision)) {
                context.hide(); // Hide the post if rejected
            }

            // Update the post with the new state
            updatePostState(post, context);
            return true;
        }
        return false;
    }

    private void updatePostState(Post post, PostContext context) {
        // Check the current state and update the post accordingly
        if (context.getCurrentState() instanceof VisibleState) {
            post.setVisible(true);
            post.setFlagged(false);
        } else if (context.getCurrentState() instanceof HiddenState) {
            post.setVisible(false);
        } else if (context.getCurrentState() instanceof FlaggedState) {
            post.setFlagged(true);
        }

        postRepository.save(post);
    }

    public int incrementRemovedPostCount(String userId) {
        // Logic to increment the count
        // This might involve retrieving a user object and updating a count field
        // For simplicity, we're just returning a dummy value here
        return 1; // Replace with actual logic
    }
}
