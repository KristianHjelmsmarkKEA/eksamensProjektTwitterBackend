package eksamensprojektbackend.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Table(name="posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private LocalDateTime createdDate;

    @Column
    private String authorUser;

    @Column
    private String postImage;

    @ManyToOne
    @JoinColumn(name= "userId")
    @Nullable
    private User user;

    @ManyToOne
    @JoinColumn(name= "hashtagId")
    @Nullable
    private Hashtag hashtag;


}
