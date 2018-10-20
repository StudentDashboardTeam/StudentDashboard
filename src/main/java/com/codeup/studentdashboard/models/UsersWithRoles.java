package com.codeup.studentdashboard.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsersWithRoles extends User implements UserDetails {

        public UsersWithRoles(User user) {
            super(user);  // Call the copy constructor defined in User
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            String roles = ""; // Since we're not using the authorization part of the component
            return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
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

        @Override
        public String getUsername() {
            return username();
        }

        @Override
        public String getPassword() {
            return password();
        }

//        @Override
//        public String getPassword() {
//            return users.username;
//        }
    }
