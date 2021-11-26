package project.memories.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("memories")
public class MemoriesProperties {
    private BucketProperties bucket;
    private TempFolderProperties tempFolder;

    @Data
    public static class BucketProperties {
        private String name;
    }

    @Data
    public static class TempFolderProperties {
        private String path;
        private String tempFilePrefix;
    }
}
