    package it.konvergence.myproject.config;

    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

    /**
     * @author Gianluca Ferruzzi
     * @version 1.0
     * @since 12/13/23
     */

    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public class SpringSecurity {


        private final UserDetailsService userDetailsService;


        @Bean
        public static PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

    //    @Bean
    //    public InMemoryUserDetailsManager userDetailsService() {
    //        UserDetails user1 = User.builder()
    //                .username("mike")
    //                .password(encoder().encode("important"))
    //                .roles("CAPTAIN", "CREW")
    //                .build();
    //        UserDetails user2 = User.builder()
    //                .username("henrik")
    //                .password(encoder().encode("important"))
    //                .roles("CREW")
    //                .build();
    //        return new InMemoryUserDetailsManager(user1, user2);
    //    }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .cors().and()
                    .httpBasic(Customizer.withDefaults())
                    .authorizeHttpRequests(authz -> authz
                            .requestMatchers("/saveUser").permitAll()
                            .requestMatchers("/arealo").permitAll()
                            .requestMatchers("/save").hasRole("CAPTAIN")
                            .requestMatchers("/cards").hasRole("CREW")
                            .requestMatchers("/users").hasRole("CAPTAIN")

                    )

                    .formLogin(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

            return http.build();



        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
        }
    }
