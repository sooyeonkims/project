package sully.project.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;

    @NotEmpty(message = "아이디를 입력해주세요")
    private String loginId; //로그인 아이디

    @NotEmpty(message = "이름을 입력해주세요")
    private String name;  //사용자 이름

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;


}
