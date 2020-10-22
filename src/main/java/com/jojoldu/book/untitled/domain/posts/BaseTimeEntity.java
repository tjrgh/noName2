package com.jojoldu.book.untitled.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//jpa entity클래스들이 이 클래스를 상속하면, 이클래스의 필드들도 컬럼으로 만들어진다.
@EntityListeners(AuditingEntityListener.class)//'Auditing'기능을 포함시킨다.
public class BaseTimeEntity {
    @CreatedDate//엔터티가 생성되어저장시, 시간이 자동저장.ㅏ
    private LocalDateTime createdDate;

    @LastModifiedDate//조회한 엔터티값 변경시 시간이 자동 저장.
    private LocalDateTime modifiedDate;
}
