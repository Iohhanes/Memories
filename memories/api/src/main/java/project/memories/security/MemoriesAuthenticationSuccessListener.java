package project.memories.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import project.memories.models.MemoriesUser;
import project.memories.models.MemoriesUserClaimKey;
import project.memories.repository.MemoriesUserRepository;

import java.util.Map;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class MemoriesAuthenticationSuccessListener {
    private final MemoriesUserRepository memoriesUserRepository;

    @EventListener(AuthenticationSuccessEvent.class)
    public void processUserInfo(AuthenticationSuccessEvent event) {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) event.getAuthentication();
        Jwt jwt = (Jwt) jwtAuthenticationToken.getPrincipal();
        Map<String, Object> claims = jwt.getClaims();

        String username = SecurityUtils.getMemoriesUserClaimValue(claims, MemoriesUserClaimKey.USERNAME, null);
        Optional<MemoriesUser> memoriesUserOptional = memoriesUserRepository.findByUsername(username);
        if (memoriesUserOptional.isEmpty()) {
            memoriesUserRepository.save(SecurityUtils.extractUserInfoFromClaims(claims));
        }
    }
}
