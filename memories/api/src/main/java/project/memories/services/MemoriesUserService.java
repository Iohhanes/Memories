package project.memories.services;

import project.memories.models.MemoriesUser;

public interface MemoriesUserService {
    MemoriesUser findByUsername(String username);
}
