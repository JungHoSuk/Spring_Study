package com.example.basic.domain.entity;

import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class EntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void memberTest(){
        Member memberA = new Member();
        Member memberB = new Member();

        memberA.setMemberName("한동석");
        memberA.setMemberEmail("tedhan1204@gmail.com");
        memberA.setMemberPassword("1234");
        memberA.setMemberAge(20);
        memberA.setMemberType(MemberType.MEMBER);

        memberB.setMemberName("장선홍");
        memberB.setMemberEmail("jsh0419@gmail.com");
        memberB.setMemberPassword("5060");
        memberB.setMemberAge(20);
        memberB.setMemberType(MemberType.ADMIN);

//        영속성 컨텍스트에 등록
        entityManager.persist(memberA);
        entityManager.persist(memberB);

        Member findMember = entityManager.find(Member.class, 1L);

        if(Optional.ofNullable(findMember).isPresent()){
            assertThat(findMember.getMemberEmail()).isEqualTo("tedhan1204@gmail.com");
        }
    }
}














