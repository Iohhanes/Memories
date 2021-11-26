package project.memories.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {
    List<String> uploadFiles(List<MultipartFile> files);

    String getPublicDownloadUrl(String fileName);
}
