package org.zerock.ex00.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.ex00.domain.MemberVO;
import org.zerock.ex00.mappers.MemberMapper;

@Log4j2
@RequiredArgsConstructor
@Service("myUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

  private final MemberMapper memberMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    log.info("===========================");
    log.info("===========================");
    log.info("===========================");
    log.info("username: " + username);
    log.info(memberMapper);
    log.info("===========================");
    log.info("===========================");

    MemberVO memberVO = memberMapper.select(username);

    log.info(memberVO);


    if(memberVO == null){
      throw new UsernameNotFoundException("user not found");
    }

    return memberVO;

  }
}
