package umc.study.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean //HttpSecurity 객체를 통해 보안 설정 구성
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        //특정 URL 패턴에 대한 접근 권한 설정. permitAll(): 인증 없이 접근 가능한 경로 지정
                        .requestMatchers("/", "/home", "/signup", "/members/signup","/css/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN 역할을 가진 사용자만 접근 가능하도록 제한
                        .anyRequest().authenticated() //인증 된 사용자만 접근 가능
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) //로그인 성공 시 /home으로 리다이렉트
                        .permitAll() //로그인 페이지는 모든 사용자가 접근 가능
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") //로그아웃 성공 시 /login?logout으로 리다이렉트
                        .permitAll()
                );

        return http.build();
    }

    @Bean //비밀번호 암호화해서 저장하기
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
