package com.kamil;

import com.kamil.model.ClipRequest;
import com.kamil.model.DownloadResult;
import com.kamil.download.DownloadEngine;
import com.kamil.download.MockDownloadImpl;
public class Main {
    public static void main(String[] args) {
        //request
        ClipRequest request = new ClipRequest.Builder()
                                                .inputPath("https://youtube")
                                                .startTime("00:02:00")
                                                .endTime("00:03:00")
                                                .outputName("test_video.mp4")
                                                .build();
        // MockUp
        DownloadEngine engine = new MockDownloadImpl();
        // Execute
        System.out.println("Testing Segmen");
        DownloadResult result = engine.download(request.getInputPath(), request, null);

        // cek hasil
        if (result.isSuccess()) {
            System.out.println("Testing Success");
            System.out.println("file disimpan di: " + result.getFilePath());
        }
    }
}
