package com.kamil;

import com.kamil.model.ClipRequest;
public class Main {
    public static void main(String[] args) {
        // Input URL
        String url = "";

        // Susunan Order pake Builder

        ClipRequest request = new ClipRequest.Builder()
                                    .inputPath(url)
                                    .startTime("00:01:21")
                                    .endTime("00:02:00")
                                    .outputName("Clipan")
                                    .build();

        // Tes Output
        System.out.println("Test");
        System.out.println("Request ID:" + request.getReqId());
        System.out.println("Start Time: " + request.getStartTime());
        System.out.println("Output : " + request.getOutputName() + ".mp4");
    }
}
