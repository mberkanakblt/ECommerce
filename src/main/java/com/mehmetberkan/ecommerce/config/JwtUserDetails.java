package com.mehmetberkan.ecommerce.config;

import com.mehmetberkan.ecommerce.entity.Kullanici;
import com.mehmetberkan.ecommerce.entity.UserRole;
import com.mehmetberkan.ecommerce.service.KullaniciService;
import com.mehmetberkan.ecommerce.service.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {
    private final KullaniciService kullaniciService;
    private final UserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserById(Long userId) {
        // 1. adım bu id ye sahip bir kullanıcı var mı?
        Optional<Kullanici> kullanici = kullaniciService.findByUserId(userId);
        if(kullanici.isEmpty()) return null;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // user role servisinden userId si,ne ait rollerin listesini çelkiyoruz.
        List<UserRole> roleLists = userRoleService.findAllRole(userId);
        // bu rol listesini GrantedAuthority içerisine ekliyoruz.
        roleLists.forEach(r->{
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        return User.builder()
                .username(kullanici.get().getEmail())
                .password(kullanici.get().getPassword())
                .accountLocked(false)
                .accountExpired(false)
                .authorities(grantedAuthorities)
                .build();
    }
}
