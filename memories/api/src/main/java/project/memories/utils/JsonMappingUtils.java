package project.memories.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JsonMappingUtils {
    private final ObjectMapper objectMapper;

    public <T> T readObjectFromMultiPart(MultipartFile json, Class<T> tClass) {
        try {
            if (json != null && !json.isEmpty()) {
                return objectMapper.readValue(json.getBytes(), tClass);
            }
        } catch (IOException exception) {
            log.error("Error while reading json: {}", exception.getMessage());
        }
        return null;
    }
}
