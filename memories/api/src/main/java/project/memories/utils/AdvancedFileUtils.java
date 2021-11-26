package project.memories.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import project.memories.properties.MemoriesProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AdvancedFileUtils {
    private final MemoriesProperties memoriesProperties;

    public String generateFilename(MultipartFile multiPart) {
        return Optional.ofNullable(multiPart)
                .map(MultipartFile::getOriginalFilename)
                .map(originalFilename -> UUID.randomUUID() + "_" + originalFilename.replaceAll("[\\s_]+", ""))
                .orElse(null);
    }

    public File convertMultipartFileToFile(MultipartFile multipartFile) {
        String fileExtension = Optional.ofNullable(multipartFile.getOriginalFilename())
                .map(this::getFileExtension)
                .orElse(null);

        if (fileExtension != null) {
            try {
                File file = File.createTempFile(
                        memoriesProperties.getTempFolder().getTempFilePrefix(),
                        fileExtension,
                        new File(memoriesProperties.getTempFolder().getPath())
                );
                new FileOutputStream(file).write(multipartFile.getBytes());
                return file;
            } catch (IOException exception) {

            }
        }

        return null;
    }

    private String getFileExtension(String filename) {
        int index = filename.lastIndexOf('.');
        return index > 0 ? filename.substring(index) : null;
    }
}
