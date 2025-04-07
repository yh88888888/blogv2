package shop.mtcoding.blog.board;

import jdk.jfr.MetadataDefinition;
import lombok.Data;
import shop.mtcoding.blog.user.User;

public class BoardRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;
        private String isPublic;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .isPublic(isPublic==null)//공백들어오거나 == nul
                    .user(null) //user 객체필요, 쿼리를 만지지 않고 자바 객체만 만진다.
                    .build();
        }
    }
}
