package eksamensprojektbackend.twitter.repositories;

import eksamensprojektbackend.twitter.models.Hashtag;
import eksamensprojektbackend.twitter.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepo extends JpaRepository <Post, Long> {


}
