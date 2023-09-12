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
public class Subscribe {
    @Id
    @Column(name = "subs_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "subscribeSequence")
    @SequenceGenerator(name = "subscribeSequence", sequenceName = "SEQ_SUBSCRIBE", allocationSize = 1)
    private int subsCode;

    @Column(name = "subs_date")
    private Date susDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "channel_code")
    private Channel channel;
}
