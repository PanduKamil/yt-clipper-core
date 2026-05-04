package com.kamil.download;

import com.kamil.model.ClipRequest;
import com.kamil.model.DownloadResult;

public class MockDownloadImpl implements DownloadEngine{
    @Override
    public DownloadResult download(String url, ClipRequest request, DownloadProgressListener listener){
      System.out.println("[Testing] Simulasi Download untuk: " + url);  
      //simulasi progress
      if (listener != null) {
        listener.onDownloadProgress(request.getReqId(), 50, 500, 1000);
        System.out.println("[Testing] Progress: 50%");
      }
      //simulasi sukses
      return DownloadResult.success(request.getReqId(), "/tmp/mock_video.mp4", 1024567L);
    }

    @Override
    public VideoMetadata fetchMetadata(String url){
        return new VideoMetadata("Simulasi", 300, "http://image.jpg", true);
    }

    @Override
    public void validateEnvironment(){
        System.out.println("[Testing] Masuk");

    }
}
