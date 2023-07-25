package net.softsociety.exam.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 정보 (시큐리티를 사용한 회원 인증에 사용)
 * UserDetails 인터페이스를 implements
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
	private static final long serialVersionUID = 3222388532456457383L;

	String memberid;
	String memberpw;
	String membername;	
	String phone;
	boolean enabled;			//계정상태. 1:사용가능, 0:사용불가능
	String rolename;			//사용자 구분. 'ROLE_USER':일반사용자
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() {
		return this.memberpw;
	}
	
	@Override
	public String getUsername() {
		return this.memberid;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
