package eksamensprojektbackend.twitter.controllers;

import eksamensprojektbackend.twitter.models.Hashtag;
import eksamensprojektbackend.twitter.models.Post;
import eksamensprojektbackend.twitter.repositories.HashtagsRepo;
import eksamensprojektbackend.twitter.repositories.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Posts {

    @Autowired
    PostsRepo posts;

    @Autowired
    HashtagsRepo hashtags;


    @GetMapping("/posts")
    public Iterable<Post> getPost() {
        return posts.findAll();
    }


    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return posts.findById(id).get();
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        newPost.setId(null);
        return posts.save(newPost);
    }

    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post postToUpdate) {
        if (posts.existsById(id)) {
            postToUpdate.setId(id);
            posts.save(postToUpdate);
            return "Post updated";
        } else {
            return "Post not found/updated";
        }
    }

    @PatchMapping("/posts/{id}")
    public String patchPost(@PathVariable Long id, @RequestBody Post postToUpdate) {
        return posts.findById(id).map( foundPost -> {
            if(postToUpdate.getPostImage() != null) foundPost.setPostImage(postToUpdate.getPostImage());
            if(postToUpdate.getHashtag() != null) foundPost.setHashtag(postToUpdate.getHashtag());
            if(postToUpdate.getText() != null) foundPost.setText(postToUpdate.getText());
            posts.save(foundPost);
            return "Post updated";
        }).orElse("Post not found/updated");
    }
    
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        posts.deleteById(id);
    }
}
