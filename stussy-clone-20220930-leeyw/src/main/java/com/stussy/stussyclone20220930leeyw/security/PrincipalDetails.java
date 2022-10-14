package com.stussy.stussyclone20220930leeyw.security;

import com.stussy.stussyclone20220930leeyw.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails  implements UserDetails {

    private User user;
    public PrincipalDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(() -> user.getRole().getName());
        return authorities;
        // return 할때 authorities 을 사용하려면 Collection 에 extends GrantedAuthority 상속받은 애들만 return 을 사용할수있다.
        // 여기서만 사용하기 때문에 익명 클래스로 만들것이다.
        // add 에 GrantedAuthority 객체가 들어가야한다. GrantedAuthority 객체는 user.getRole().getName()이다.
        // security가
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
        return true;
    }
}
