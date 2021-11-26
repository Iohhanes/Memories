package project.memories.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.memories.properties.MemoriesProperties;
import project.memories.services.StorageService;
import project.memories.utils.AdvancedFileUtils;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final MemoriesProperties memoriesProperties;
    private final AdvancedFileUtils advancedFileUtils;
    private final AmazonS3 s3Client;

    @Override
    public List<String> uploadFiles(List<MultipartFile> files) {
        return Optional.ofNullable(files)
                .stream()
                .flatMap(Collection::stream)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @Override
    public String getPublicDownloadUrl(String fileName) {
        URL url = s3Client.getUrl(memoriesProperties.getBucket().getName(), fileName);
        return url.toString();
    }

    private String uploadFile(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            File conFile = advancedFileUtils.convertMultipartFileToFile(file);
            if (conFile != null) {
                String filename = advancedFileUtils.generateFilename(file);
                s3Client.putObject(new PutObjectRequest(memoriesProperties.getBucket().getName(), filename, conFile));
                s3Client.setObjectAcl(memoriesProperties.getBucket().getName(), filename, CannedAccessControlList.PublicRead);
                conFile.delete();
                return filename;
            }
        }
        return null;
    }
}

