package com.kh.youtube.repo;

import com.kh.youtube.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberDAO extends JpaRepository<Member, String> { // 엔티티가 될 객체가 앞(vo, dto), 프라이머리 키의 변수 타입이 뒤

    Member findByIdAndPassword(String id, String password);

}
