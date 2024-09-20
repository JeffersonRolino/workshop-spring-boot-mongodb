package jeffersonrolino.com.github.workshopmongo.service;

import jeffersonrolino.com.github.workshopmongo.domain.Post;
import jeffersonrolino.com.github.workshopmongo.repository.PostRepository;
import jeffersonrolino.com.github.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }
        else {
            throw new ObjectNotFoundException("Post não encontrado");
        }
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
