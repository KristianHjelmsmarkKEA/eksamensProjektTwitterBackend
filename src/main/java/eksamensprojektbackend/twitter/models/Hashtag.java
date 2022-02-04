package eksamensprojektbackend.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="hashtags")
@Entity
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tag;

    @JsonIgnore
    @Nullable
    @OneToMany(mappedBy = "hashtag", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;
}
