package com.kh.youtube.repo;

import com.kh.youtube.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChannelDAO extends JpaRepository<Channel, Integer> {

    // 특정 멤버의 모든 채널을 조회
    // SELECT * FROM CHANNEL WHERE member_id = ?
    @Query(value = "SELECT * FROM CHANNEL WHERE member_id = :memberId", nativeQuery = true)
    List<Channel> findByMemberId(String memberId);
}
