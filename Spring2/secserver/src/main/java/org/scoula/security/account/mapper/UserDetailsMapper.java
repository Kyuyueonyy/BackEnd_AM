package org.scoula.security.account.mapper;

import org.scoula.security.account.domain.MemberVO;

//login처리할 때 db연동할 기능을 정의하면 됨
//username(id) 주소 회원정보를 검색하자
public interface UserDetailsMapper {
    public MemberVO get(String username);
}
