package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "commLikeSequence")
    @SequenceGenerator(name = "commLikeSequence", sequenceName = "SEQ_COMMENT_LIKE", allocationSize = 1)
    @Column(name = "comm_like_code")
    private int commLikeCode;

    @Column(name = "comm_like_date")
    private Date commLikeDate;

    @ManyToOne
    @JoinColumn(name = "comment_code")
    private VideoComment videoComment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;
}
