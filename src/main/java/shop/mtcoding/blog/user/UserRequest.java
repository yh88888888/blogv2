package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {

    // insert 용도의 dto에는 toEntity메서드를 만든다.
    //Controller에서 heap에 띄워놓은 상태\
    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
            //static이 아니므로
            //from to 패턴
        }
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }
}