package com.iu.sl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 22:22
 */
@Component
public class JwtTokenUtil {

    public static String generatorToken(JwtInfo jwtInfo,int expire){
        return Jwts.builder().claim(JwtContants.JWT_KET_USER_ID,jwtInfo.getUid())//目前只传一个参数进去
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.HS256,getKeyInstance()).compact();

    }

    public static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary("user-token");
        return new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }

    public static JwtInfo getToken(String token){
        Jws<Claims> jws  = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        Claims claims = jws.getBody();
        return new JwtInfo(claims.get(JwtContants.JWT_KET_USER_ID).toString());
    }

}
