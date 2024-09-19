package jeffersonrolino.com.github.workshopmongo.controller;

import jeffersonrolino.com.github.workshopmongo.domain.User;
import jeffersonrolino.com.github.workshopmongo.dto.UserDTO;
import jeffersonrolino.com.github.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> userDTOList = list.stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(userDTOList);
    }
}
