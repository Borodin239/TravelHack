package moscow.travelhack.russpass.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "tutorialspoint";
    private String clientSecret = "my-secret-key";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEAuJbwp2Pd/tMVgW7d5pA7/hdHfdttrL6NPWousNM21XALOnRK\n" +
            "lbwkb6nSQtTR/KrKe94Ahn+ibhlaGwYnGQBvNHrsQfeq83MRwxZ2zfvFN+gCeAD/\n" +
            "xXmoCTbcaxlVClq4C4JtdCB2i3NAL5vJTM7yFeqqo8gbnIiRYZsq7efmsoSigQSo\n" +
            "+GunlBhYLalRXkWtAgLPmCgEMViDGZwdT23A/rR8YUWZ5NnIfyZYdfD0szlta2Xj\n" +
            "+TVCp41L+eGIAfOiiqyGKQSnJPgYKC0Vn6QU8ONgitudOnJl8XI5QXcAdvY4JaXZ\n" +
            "iKVrriOco8VXY++3e8bRxpTXI2EhAVWV9rt6CQIDAQABAoIBABqdIJtxyasY8gvU\n" +
            "WUgJ2ax73MHnpjt2ydRl/89c1JYXbncCF1LZaoNy/67FEnWUhlcvnfHGazvmidhF\n" +
            "ndN7/YyagH/OXqZ1G8V98qkmOLwjxl9Y/YeST8jsUQFcCKfShqCaMH/CwnS+rC1x\n" +
            "D6f0WnEQgYPVsS1zf0qMXbcpbVilihxonJmtqM5iXjT2D7O2xYQQ48oP9EPVPKBH\n" +
            "TalEOSXrfJq/Qpx0G+V0i2shqFwfAuD7UJUQk+hHhd1rXjPkh7n5XcnwGur/HP5q\n" +
            "mClqRjzLn348SsB3nBLupHojKFNyrxqrlWwg/stbWpTg13D5WbtaR0XFUujyEYU1\n" +
            "ldaaU4ECgYEA58Cvz8D27x0bACyuhxVsKtmLscCbhKyXOhYFEqXtY++5nQwCTlFx\n" +
            "cTq6cdovm6f/z0E+21VtlH2Veg1BqkwRd66TE2I1Y2+bwikxxe4xGfAffWtH56a7\n" +
            "aAuCQEEoz/dw398kQnDaI26Dt1MRaVruv/SOaaundHhqZ/qBqybYHBECgYEAy+cH\n" +
            "CaaVaJEhJPqo5dEkCNdB1DR773+6sHC/tagRkdvI0VjJ4fLc90oLexznlu4JOuWT\n" +
            "SAbTtdXHbafGe8o8xq8YgateExnmue1UDTv2f5fkhrat73sa0Gv5JWKbqY88BEcx\n" +
            "Ji2JzQxHmhlsCz8IUSjGRlig6TsET4v8cmEg1nkCgYBSd83YNwloE0pdaIj+htAD\n" +
            "+3/rU+fDcYsq31UUyrjL/C1nxjM33WFp8oUQKJ0SXdj4znXopOCmm33KfdclG4aH\n" +
            "uTabCjKHXNrnX7NXhKgyW7FI9xkSRNGhd5708HrublXbRFNp1TC6tQPoA4ZJoFMf\n" +
            "OY5H6g5fss3ijFECL4NtkQKBgBMBtRE8Ov8lUB6fUvEhPqeoURWT0t2vXVqnF+e6\n" +
            "A/FBuIVzLlZmihxvBYTzW88g3zFjRwhWwpNXmyBonELbxjCLD9C+haVoK663Jbea\n" +
            "GE8qfH3mN250XjqBZhcLCxGSLXkEnds+MXMwqtf9eKnPtVnDYEAccNtsyekUVnLf\n" +
            "BO2ZAoGAWH8RF0cUlYQ3CYoIEvqi9HJtZ3RCmoHRvneh0ZiW/CL9zKerIvNIMZj6\n" +
            "bnSnfbF5HyxKDBNF8l+wQXys+3OVrl9U6DUVmaqikNvIbOMggV4iwdUdq2Oun9Ll\n" +
            "QOnqBH1m84cIxQ6jPvHeokN+tz9Ye9HNhOWfmsxP03YbkeLoEHc=\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuJbwp2Pd/tMVgW7d5pA7\n" +
            "/hdHfdttrL6NPWousNM21XALOnRKlbwkb6nSQtTR/KrKe94Ahn+ibhlaGwYnGQBv\n" +
            "NHrsQfeq83MRwxZ2zfvFN+gCeAD/xXmoCTbcaxlVClq4C4JtdCB2i3NAL5vJTM7y\n" +
            "Feqqo8gbnIiRYZsq7efmsoSigQSo+GunlBhYLalRXkWtAgLPmCgEMViDGZwdT23A\n" +
            "/rR8YUWZ5NnIfyZYdfD0szlta2Xj+TVCp41L+eGIAfOiiqyGKQSnJPgYKC0Vn6QU\n" +
            "8ONgitudOnJl8XI5QXcAdvY4JaXZiKVrriOco8VXY++3e8bRxpTXI2EhAVWV9rt6\n" +
            "CQIDAQAB\n" +
            "-----END PUBLIC KEY----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}

