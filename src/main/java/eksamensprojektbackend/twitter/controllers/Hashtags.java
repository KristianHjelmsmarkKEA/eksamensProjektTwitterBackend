package eksamensprojektbackend.twitter.controllers;

import eksamensprojektbackend.twitter.models.Hashtag;
import eksamensprojektbackend.twitter.repositories.HashtagsRepo;
import eksamensprojektbackend.twitter.repositories.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hashtags {
    @Autowired
    HashtagsRepo hashtags;

    @Autowired
    PostsRepo posts;

    @GetMapping("/hashtags")
    public Iterable<Hashtag> getHashtag() {
        return hashtags.findAll();
    }

    @GetMapping("/hashtags/{id}")
    public Hashtag getHashtag(@PathVariable Long id) {
        return hashtags.findById(id).get();
    }

    @PostMapping("/hashtags")
    public Hashtag addHashtag(@RequestBody Hashtag newHashtag) {
        newHashtag.setId(null);
        return hashtags.save(newHashtag);
    }

    @PutMapping("/hashtags/{id}")
    public String updateCandidate(@PathVariable Long id, @RequestBody Hashtag hashtagToUpdate) {
        if (hashtags.existsById(id)) {
            hashtagToUpdate.setId(id);
            hashtags.save(hashtagToUpdate);
            return "Hashtag updated";
        } else {
            return "Hashtag not found/updated";
        }
    }

    /*
    @PatchMapping("/hashtags/{id}")
    public String patchHashtag(@PathVariable Long id, @RequestBody Hashtag hashtagToUpdate) {
        return hashtags.findById(id).map( foundHashtag -> {
            if(hashtagToUpdate.getTag() != null) foundHashtag.setTag(hashtagToUpdate.getTag());
            hashtags.save(foundHashtag);
            return "Hashtag updated";
        }).orElse("Hashtag not found/updated");
    }
     */

    @DeleteMapping("/hashtags/{id}")
    public void deleteHashtag(@PathVariable Long id) {
        hashtags.deleteById(id);
    }
}
