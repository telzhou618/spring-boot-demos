package com.example.service;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.bean.User;
import com.example.config.JwtProp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhou1
 */
@Service
@AllArgsConstructor
public class JwtService {

    private final JwtProp jwtProp;

    /**
     * 生成 Token
     */
    public String createUserToken(User user) {
        Assert.notNull(user, "user is not null");

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 24);
        Date expiresDate = nowTime.getTime();

        return JWT.create()
                .withIssuer("auth0")
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("user", JSON.toJSONString(user))
                .sign(Algorithm.HMAC256(jwtProp.getSecret()));
    }

    /**
     * 验证token
     */
    public DecodedJWT verify(String token) {
        Assert.notNull(token, "token is not null");
        Algorithm algorithm = Algorithm.HMAC256(jwtProp.getSecret());
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //可重用的验证程序实例
        return verifier.verify(token);
    }
}
