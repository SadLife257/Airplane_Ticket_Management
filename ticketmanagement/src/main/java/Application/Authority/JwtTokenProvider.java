package Application.Authority;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtTokenProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
	
	private final String JWT_SECRET = "account";

    private final long JWT_EXPIRATION = 24 * 60 * 60 * 1000;

    public String generateToken(Authentication authentication) {
    	AccountDetail principal = (AccountDetail) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((principal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
    }

    public String getUserNameFromJwtToken(String token) {
    	return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
