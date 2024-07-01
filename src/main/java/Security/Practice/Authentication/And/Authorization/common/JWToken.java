package Security.Practice.Authentication.And.Authorization.common;

import java.sql.Date;

import org.springframework.stereotype.Component;

import Security.Practice.Authentication.And.Authorization.entity.Students;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWToken {
	
	private static String secret ="This Is Secret";
	
	private static long expiryduration= 60 * 60;
	
	public String GenerateJWT(Students students) {
		long milliTime =System.currentTimeMillis();
		long expiryTime = milliTime + expiryduration * 1000;
		Date issuedAt =new Date(milliTime);
		Date expiryAt = new Date(expiryTime);
		
		Claims claims=Jwts.claims().setIssuer(students.getStudentId().toString());
		claims.setIssuedAt(issuedAt).setExpiration(expiryAt);
		claims.put("Name",students.getStudentName());
		claims.put("Age",students.getStudentAge());
		claims.put("Gender",students.getGender());
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		
	}
	
	public Claims verify(String authorizaton)throws Exception{
		try {
		Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(authorizaton).getBody();
		return claims;
		}catch (Exception e) {
			throw new Exception();
		}
	}
	
	

}
