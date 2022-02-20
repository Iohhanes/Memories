package project.memories.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import project.memories.models.MemoriesUser;
import project.memories.models.MemoriesUserClaimKey;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SecurityUtils {

    public static Optional<MemoriesUser> getCurrentMemoriesUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(principal -> (Jwt) principal)
                .map(jwt -> extractUserInfoFromClaims(jwt.getClaims()));
    }

    public static MemoriesUser extractUserInfoFromClaims(Map<String, Object> claims) {
        return MemoriesUser.builder()
                .username(getMemoriesUserClaimValue(claims, MemoriesUserClaimKey.USERNAME, null))
                .email(getMemoriesUserClaimValue(claims, MemoriesUserClaimKey.EMAIL, null))
                .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getMemoriesUserClaimValue(Map<String, Object> claims, MemoriesUserClaimKey key, T defaultValue) {
        return (T) claims.getOrDefault(key.getValue(), defaultValue);
    }

    public static List<GrantedAuthority> extractAuthorityFromClaims(Map<String, Object> claims) {
        return mapRolesToGrantedAuthorities(getMemoriesUserClaimValue(claims, MemoriesUserClaimKey.ROLES, new ArrayList<>()));
    }

    private static List<GrantedAuthority> mapRolesToGrantedAuthorities(Collection<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
