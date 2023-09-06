package com.kh.youtube.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String memberId;
    private String memberPassword;
    private String memberNicknam;
    private String memberEmail;
    private String memberPhone;
    private char memberGender;
    private String memberAuthority;
}
