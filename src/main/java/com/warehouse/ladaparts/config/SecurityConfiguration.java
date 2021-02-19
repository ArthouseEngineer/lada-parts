package com.warehouse.ladaparts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String WATCHER = "WATCHER";
    private static final String[] permitWatcher = new String[]{"*/parts/GetParts", "*/parts/getPartCart"};
    private static final String[] permitAdmin = new String[]{"*/parts/updatePart", "*/parts/savePart", "*/parts/setModelCompatibility", "*/parts/deletePartById"};


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("user")).roles(WATCHER)
                .and()
                .withUser("admin").password(encoder.encode("admin")).roles(ADMIN, WATCHER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(permitWatcher)
                .hasRole(WATCHER)
                .antMatchers(permitAdmin)
                .hasRole(ADMIN)
                .and()
                .httpBasic();
    }

}
