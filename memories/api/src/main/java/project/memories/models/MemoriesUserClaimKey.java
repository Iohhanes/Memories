package project.memories.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MemoriesUserClaimKey {
    USERNAME("preferred_username"),
    EMAIL("email"),
    ROLES("roles");

    @Getter
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
