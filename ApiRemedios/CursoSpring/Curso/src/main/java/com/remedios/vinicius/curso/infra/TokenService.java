package com.remedios.vinicius.curso.infra;



import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.remedios.vinicius.curso.usuarios.Usuario;

@Service
public class TokenService {

	@Value("${JWT_Secret:123456}")
	private String secret;
	
	public String gerartoken(Usuario usuario) {
		try {
		    var algorithm = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("Remedios_api")
		        .withSubject(usuario.getLogin())
		        .withExpiresAt(dataExpiração())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		  throw new RuntimeException("erro ao gerar token", exception);
		}
	}

	public String getSubject(String tokenJWT) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
		    return JWT.require(algorithm)		        
		        .withIssuer("Remedios_api")
		        .build()
		        .verify(tokenJWT)
		        .getSubject();
		        
		   
		} catch (JWTVerificationException exception){
			throw new RuntimeException("Token invalido ou expirado");
		}
	}
	
	private Instant dataExpiração() {	
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
