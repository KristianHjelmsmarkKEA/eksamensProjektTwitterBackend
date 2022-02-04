package eksamensprojektbackend.twitter.controllers;

import eksamensprojektbackend.twitter.models.Post;
import eksamensprojektbackend.twitter.models.User;
import eksamensprojektbackend.twitter.repositories.PostsRepo;
import eksamensprojektbackend.twitter.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Users {

    @Autowired
    UsersRepo users;


    @GetMapping("/users")
    public Iterable<User> getUser() {
        return users.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return users.findById(id).get();
    }

    @PostMapping("/users")
    public User addPost(@RequestBody User newUser) {
        newUser.setId(null);
        return users.save(newUser);
    }

    @PutMapping("/users/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody User userToUpdate) {
        if (users.existsById(id)) {
            userToUpdate.setId(id);
            users.save(userToUpdate);
            return "User updated";
        } else {
            return "User not found/updated";
        }
    }

    @PatchMapping("/users/{id}")
    public String patchUser(@PathVariable Long id, @RequestBody User userToUpdate) {
        return users.findById(id).map( foundUser -> {
            if(userToUpdate.getUsername() != null) foundUser.setUsername(userToUpdate.getUsername());
            if(userToUpdate.getDescription() != null) foundUser.setDescription(userToUpdate.getDescription());
            users.save(foundUser);
            return "User information updated";
        }).orElse("User not found/updated");
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.deleteById(id);
    }
}
