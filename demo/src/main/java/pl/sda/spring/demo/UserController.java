package pl.sda.spring.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users/{id}/{idf}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable Long id, @PathVariable Long idf) {
        User userById = userRepository.findUserById(id);
        return new ResponseEntity(userById, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) throws JsonProcessingException {
        User savedUser = userRepository.save(user);
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }

}
