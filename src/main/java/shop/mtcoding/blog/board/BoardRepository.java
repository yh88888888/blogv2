package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    public List<Board> findAll(Integer userId) {
        String s1 = "select b from Board b where b.isPublic = true or b.user.id = :userId order by b.id desc";
        String s2 = "select b from Board b where b.isPublic = true order by b.id desc";

        Query query = null;
        if (userId == null) {
            query = em.createQuery(s2, Board.class);
        } else {
            query = em.createQuery(s1, Board.class);
            query.setParameter("userId", userId);
        }

        return query.getResultList();
    }

    public void save(Board board) {
        em.persist(board);

    }


}

//    public Board findByIdV1(int id) {
//        Query query = em.createNativeQuery("select bt.id, bt.title, bt.content, bt.is_public, bt.created_at, ut.id user_id, ut.username, ut.password, ut.email, ut.created_at from board_tb bt inner join user_tb ut on bt.user_id = ut.id where bt.id = ?");
//        query.setParameter(1, id);
//
//        Object[] obs = (Object[]) query.getSingleResult();
//
//        User user = User.builder()
//                .id((int) obs[5])
//                .username((String) obs[6])
//                .password((String) obs[7])
//                .email((String) obs[8])
//                .createdAt((Timestamp) obs[9])
//                .build();
//
//        Board board = Board.builder()
//                .id((int) obs[0])
//                .title((String) obs[1])
//                .content((String) obs[2])
//                .isPublic((boolean) obs[3])
//                .createdAt((Timestamp) obs[4])
//                .user(user)
//                .build();
//
//        return board;
//    }
//
//    public Board findByIdV2(int id) {
//        return em.find(Board.class, id);
//    }
//}