package com.freedom.mybatisplus.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;


/**
 * @author ：wujie
 * @date ：Created in 2019/12/24 16:59
 * @description：JWT工具类
 * @version: 1.0.0
 */
@Component
public class JwtUtils {
    /**
     * 过期时间 30分钟
     */
    private static Long EXPIRE_TIME=(long)(30*60*1000);

    /**
     * 秘钥
     */
    private static String SECRET="freedom";

    private static Logger log = LoggerFactory.getLogger(JwtUtils.class);

    //该方法使用HS256算法和Secret:bankgl生成signKey
    private static Key getKeyInstance() {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    //使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
    public static String createJavaWebToken(Map<String, Object> claims) {
        long expire = System.currentTimeMillis()+EXPIRE_TIME;
        return Jwts.builder().setClaims(claims).setExpiration(new Date(expire)).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    //解析Token，同时也能验证Token，当验证失败返回null
    public static Map<String, Object> parserJavaWebToken(String jwt) {
        try {
            //解析过程中，如果token错误或者token过期，则会抛出异常
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            throw new RuntimeException("json web token verify failed");
        }
    }
}
