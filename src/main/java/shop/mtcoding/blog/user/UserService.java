package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


//비지니스로직, 트랜잭션처리, DTO 완료
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
//        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getEmail());
        try {
            userRepository.save(joinDTO.toEntity());
        }
        catch (Exception e) {
            throw new RuntimeException("야 동일한 아이디로 회원가입하는...하지마라! 포스트맨 쓰지마라");
        }


    }

    public User 로그인(UserRequest.LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("유저네임 혹은 비밀번호가 틀렸습니다");
        }
        return user;
    }

    public Map<String, Object> 유저중복체크(String username) {
        User user = userRepository.findByUsername(username);
       Map<String, Object> dto = new HashMap<>();
        if (user == null) {
            dto.put("available", true);
        } else {
            dto.put("available", false);
        }
        return dto;
    }
}