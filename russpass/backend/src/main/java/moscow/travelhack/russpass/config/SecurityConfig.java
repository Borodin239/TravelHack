package moscow.travelhack.russpass.config;

import moscow.travelhack.russpass.resource.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenStore tokenStore;

    @Qualifier("customUserDetails")
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
  /*      //http
                //.antMatcher("/**")
                //.authorizeRequests()
                //.antMatchers("/oauth/authorize**", "/login**", "/error**")
                //.permitAll()
                //.and()
                //.authorizeRequests()
                //.anyRequest().authenticated()
                //.and()
                //.formLogin().permitAll();
        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();*/
//        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
    }

    @Override
    public void configure( WebSecurity web ) throws Exception
    {
        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .inMemoryAuthentication()
                .withUser("humptydumpty")
                .password(passwordEncoder.encode("123456"))
                .roles("USER");*/
        auth.userDetailsService(userDetailsService);
    }


}
