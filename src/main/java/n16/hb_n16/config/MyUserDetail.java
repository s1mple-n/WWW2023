package n16.hb_n16.config;

import n16.hb_n16.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.*;

public class MyUserDetail implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return asList(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase()));
    }



    @Override
    public String getPassword() {
        return user != null ? user.getPassword() : "";
    }

    @Override
    public String getUsername() {
        return user != null ? user.getUsername() : "";
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
