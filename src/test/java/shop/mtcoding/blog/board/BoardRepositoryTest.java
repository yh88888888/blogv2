package shop.mtcoding.blog.board;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class) //BoardRepository
@DataJpaTest //EntityManager, PC
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAll_test() {
        //given
        Integer userId = 1;
        //when  테스트코드를 작성
        List<Board> boardList = boardRepository.findAll(userId);
//        System.out.println("--------------------");
//        boardList.get(0).getUser().getUsername();
//        System.out.println("--------------------");
        //eye
        for (Board board : boardList) {
            System.out.print(board.getId()+"," + board.getTitle());
            System.out.println();
        }
    }
}
