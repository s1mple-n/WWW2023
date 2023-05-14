package n16.hb_n16.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import javax.sql.DataSource;

import static n16.hb_n16.ultility.SecurityRoles.ADMIN_ROLE;
import static n16.hb_n16.ultility.SecurityRoles.USER_ROLE;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySpringSecurityConfig {
    private final DataSource dataSource;
    @Value("${spring.admin.username}")
    private String adminUserName;
    @Value("${spring.admin.password}")
    private String adminPassword;
    @Value("${spring.queries.users-query}")
    private String usersQuery;
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    public MySpringSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());

        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$iVIV6KTf2GdAAo9FpLVpsubzVP8undhidTtCyftx.OnfBn5yn2eZW")
                .roles(ADMIN_ROLE)
                .build();

        auth.inMemoryAuthentication().withUser(admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/","/index","/home","/error").permitAll()
                                .requestMatchers("/products/product/add_to_cart/**").hasRole(USER_ROLE)
                                .requestMatchers("/cart/**").hasRole(USER_ROLE)
                                .requestMatchers("/admin/**").hasRole(ADMIN_ROLE)
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/logon")
                        .defaultSuccessUrl("/")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .loginProcessingUrl("/authenUser")
                        .permitAll()

                )

                .logout(LogoutConfigurer::permitAll)
                .httpBasic(Customizer.withDefaults());
        return http.build();


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public HttpFirewall configureFirewall(){
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
        strictHttpFirewall.setAllowUrlEncodedSlash(true);
        return strictHttpFirewall;
    }
}
