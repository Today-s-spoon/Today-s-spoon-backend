package com.example.todaySpoon.S3;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class S3Uploader {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSizeString;

    // 파일 확장자 체크
    private String validateFileExtension(String originalFilename) {
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        List<String> allowedExtensions = Arrays.asList("jpg", "png", "gif", "jpeg");

        if (!allowedExtensions.contains(fileExtension)) {
            throw new Exception400("file", ErrorMessage.NOT_IMAGE_EXTENSION);
        }
        return fileExtension;
    }

    public String getFileUrl(String fileName) {
        if (!amazonS3.doesObjectExist(bucket, fileName)) {
            throw new Exception400("fileName", ErrorMessage.NO_IMAGE_EXIST);
        }

        // 파일의 URL을 생성하고 반환
        URL url = amazonS3.getUrl(bucket, fileName);
        return url.toString();
    }

    // 400 Bad Request 예외
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class Exception400 extends RuntimeException {
        public Exception400(String field, String message) {
            super(String.format("%s: %s", field, message));
        }
    }

    // 500 Internal Server Error 예외
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public class Exception500 extends RuntimeException {
        public Exception500(String message) {
            super(message);
        }
    }
    public class ErrorMessage {
        public static final String DUPLICATE_IMAGE = "중복된 이미지입니다.";
        public static final String NO_IMAGE_EXIST = "이미지가 존재하지 않습니다.";
        public static final String FAIL_DELETE = "파일 삭제에 실패했습니다.";
        public static final String FAIL_UPLOAD = "파일 업로드에 실패했습니다.";
        public static final String NOT_IMAGE_EXTENSION = "지원하지 않는 파일 형식입니다.";
    }
}