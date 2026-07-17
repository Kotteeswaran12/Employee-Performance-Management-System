package com.employee_Manager.performance_system.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	final String SECREATEKEY = "18e05fac7bcd9e91cfdb3110289b799eabf018147ff96dc5f1b58e9f4f49e70c6aca49430d6d2b8953852e8b84a39bd7";

	public String getToken(String username) {
		// TODO Auto-generated method stub
		Map<String ,Object> claims = new HashMap<>();
		
		
		return Jwts.builder()
				.claims(claims)
				.subject(username)
				.issuer("ADMIN")
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 *30  *40) )
				.signWith(getKey())
				.compact();
	}
	
	public SecretKey getKey() {
		byte[] keyByte = Decoders.BASE64.decode(SECREATEKEY);
		return Keys.hmacShaKeyFor(keyByte);
		
	}

	public String getusername(String jwt) {
		// TODO Auto-generated method stub

		
		return ExtractfromClaims(jwt ,  Claims::getSubject);
	}


	private <T> T ExtractfromClaims(String jwt, Function<Claims, T> claimsResolve) {
		// TODO Auto-generated method stub
		
		Claims claim = getClaims(jwt);
		return claimsResolve.apply(claim);
	}

	

	private Claims getClaims(String jwt) {
		// TODO Auto-generated method stub
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(jwt)
				.getPayload();
	}

	public boolean isTokenValid(String jwt, UserDetails user) {
		// TODO Auto-generated method stub
		
		 final String username = getusername(jwt);
		return username.equals(username) && !isTokenExpried(jwt);
	}

	private boolean isTokenExpried(String jwt) {
		// TODO Auto-generated method stub
		return ExtractfromClaims(jwt, Claims::getExpiration).before(new Date());
	}

}
