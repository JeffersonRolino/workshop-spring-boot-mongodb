package jeffersonrolino.com.github.workshopmongo.service;

import jeffersonrolino.com.github.workshopmongo.domain.User;
import jeffersonrolino.com.github.workshopmongo.dto.UserDTO;
import jeffersonrolino.com.github.workshopmongo.repository.UserRepository;
import jeffersonrolino.com.github.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
