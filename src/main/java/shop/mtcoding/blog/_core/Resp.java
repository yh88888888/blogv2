package shop.mtcoding.blog._core;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private Integer status;
    private String msg;
    private T body;

    public static <B> Resp<?> ok(B body) {
        return new Resp<B>(200, "성공", body);
    }
    //제네릭함수는 new를 해야만 가능한데 우선 T body를 오브젝트라고 해서 받아놔바
//    그리고 고유의 자료형으로 입력해서 new 해 그럼 그걸로 최종 반영해줄게
//    public static <T> Resp<?> fail(Integer status, String msg) {
//        return new Resp(200,"실패")
//    }
    public static Resp<?> fail(Integer status, String msg) {
        return new Resp<>(status, msg, null);
    }
}