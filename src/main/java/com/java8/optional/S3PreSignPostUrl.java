package com.java8.optional;

import com.amazonaws.s3.S3Exception;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class S3PreSignPostUrl {

    public static void main(String[] args) {

        String bucketName = "doubledigit-datalake-qa-us-east-1";
        String keyName = "dd-react-app/";
        ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create("default");
        Region region = Region.US_EAST_1;
        S3Presigner presigner = S3Presigner.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();

        signBucket(presigner, bucketName, keyName);
        presigner.close();
    }

    // snippet-start:[presigned.java2.generatepresignedurl.main]
    public static void signBucket(S3Presigner presigner, String bucketName, String keyName) {

        try {
            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .contentType("text/plain")
                    .build();

            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(10))
                    .putObjectRequest(objectRequest)
                    .build();

            PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);
            String myURL = presignedRequest.url().toString();
            System.out.println("Presigned URL to upload a file to: " +myURL);
            System.out.println("Which HTTP method needs to be used when uploading a file: " + presignedRequest.httpRequest().method());

            // Upload content to the Amazon S3 bucket by using this URL.
            URL url = presignedRequest.url();

            // Create the connection and use it to upload the new object by using the presigned URL.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type","text/plain");
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("This text was uploaded as an object by using a presigned URL.");
            out.close();

            connection.getResponseCode();
            System.out.println("HTTP response code is " + connection.getResponseCode());

        } catch (S3Exception | IOException e) {
            e.getStackTrace();
        }
    }

}
