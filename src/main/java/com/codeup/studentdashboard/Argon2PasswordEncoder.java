package com.codeup.studentdashboard;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Argon2PasswordEncoder implements PasswordEncoder {
    private Argon2 argon2;

    public Argon2PasswordEncoder() {
        this(Argon2Factory.Argon2Types.ARGON2id);
    }

    public Argon2PasswordEncoder(Argon2Factory.Argon2Types type) {
        this.argon2 = Argon2Factory.create(type);
    }

    @Override
    public String encode(CharSequence password) {
        return argon2.hash(63, 65536, 4, password.toString().toCharArray());
    }

    @Override
    public boolean matches(CharSequence password, String hash) {
        return argon2.verify(hash, password.toString().toCharArray());
    }
}
