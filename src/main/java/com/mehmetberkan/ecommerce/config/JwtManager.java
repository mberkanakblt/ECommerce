package com.mehmetberkan.ecommerce.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * ----- Token Sınıfı.
 */
@Service
public class JwtManager {

    private String secretKey= "${my-jwt.secret-key}";
    private String issuer = "Admin1";
    private Long expirationDate = 1000L * 60*60;
    public String createToken(Long userId){
        String token="";
        Long now = System.currentTimeMillis(); // şuan ki zamanını long olarak değerini verir
        Date issuerAt = new Date(now);
        Date expiration = new Date(now + expirationDate);
        Algorithm algorithm = Algorithm.HMAC512(secretKey); // şifreleme algoritması.
        token = JWT.create()
                .withAudience()
                .withIssuer(issuer)
                .withIssuedAt(issuerAt)
                .withExpiresAt(expiration)
                .withClaim("userId", userId)
                .withClaim("ETicaret", "Yeni bir uygulama yazdık")
                .withClaim("log", "şuan saat tam olara "+ (new Date()))
                .sign(algorithm);
        return token;
    }


    public Optional<Long> validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier =  JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token); // aslında hem token bize mi ait hemde süresi doldu mu?
            if(Objects.isNull(decodedJWT)) // eğer decotedjwt boş ise
                return Optional.empty();
            Long userId = decodedJWT.getClaim("userId").asLong(); // ilgili claim nesnesini long olarak al
            return Optional.of(userId); // değeri optional olarak döndür.
        }catch (Exception exception){
            return Optional.empty();
        }
    }
}
