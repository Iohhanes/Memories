package project.memories.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.memories.models.MemoriesUser;
import project.memories.repository.MemoriesUserRepository;
import project.memories.services.MemoriesUserService;

@Service
@RequiredArgsConstructor
public class MemoriesUserServiceImpl implements MemoriesUserService {
    private final MemoriesUserRepository memoriesUserRepository;

    @Override
    public MemoriesUser findByUsername(String username) {
        return memoriesUserRepository.findByUsername(username).orElse(null);
    }
}
