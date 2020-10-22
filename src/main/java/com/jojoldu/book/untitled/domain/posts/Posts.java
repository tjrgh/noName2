package com.jojoldu.book.untitled.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter//모든 필드의 getter생성.
@NoArgsConstructor//기본생성자 추가.
@Entity//테이블고 링크될 클래스임 선언.
public class Posts extends BaseTimeEntity{

    @Id//테이블의 PK임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Pk의 생성규칙을 나타냄. 이렇게설정해야 auto_increment설정.
    private Long id;

    @Column(length =500, nullable =false)//테이블의 컬럼임을 나타냄. 안해도 컬럼이긴한데 추가옵션설정하려고.
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author=author;
    }
    /*'빌더 패턴'
    * 생성자에 인자를 나열하면 인자가 ㅁ낳아질시 수서를 헷갈릴수도있고 실수의 여지가있다.
    * 'Builder'를 이용하여 어느 필드에 어떤값을 넣어야하는지 명확하게 인지할수있다.
    * ex)   Example.builter()
    *               .a(a)
    *               .b(b)
    *               .build();
    * */

    /*setter는 만들지 않는다. 값들이 언제 어디서 변화해야하는지 코드상에서 명확히 알수없어 복잡해지기때문.
    * setter가 아닌 그 목적과 의도가 명확히 나타나는 메소드를 만들어야 한다.
    * ex)   public void cancelOrder(){
    *           this.status= false;
    *       }
    * */
}
