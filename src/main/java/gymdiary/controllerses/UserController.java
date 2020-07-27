package gymdiary.controllerses;

import gymdiary.model.entity.User;
import gymdiary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> allUsers () {
        return userRepository.getAll();
    }

    @DeleteMapping("/users")
    public String deleteUser(int id){
        userRepository.delete(id);
        return "ok";
    }

    @PostMapping("/login")
    public String login (@RequestBody User u) {

        User currentUser = userRepository.getUser(u.getLogin());
        if (currentUser != null && currentUser.getPassword().equals(u.getPassword())) return "ok";
            else return "not ok";
    }

    @PostMapping("/register")
    public String register(@RequestBody User u){
        userRepository.save(u);
        return "ok";
    }

}
