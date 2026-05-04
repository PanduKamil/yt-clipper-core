package com.kamil.download;

import com.kamil.model.ClipRequest;
import com.kamil.model.DownloadResult;
public interface DownloadEngine {
    DownloadResult download(String url, ClipRequest request, DownloadProgressListener listener);
    VideoMetadata fetchMetadata(String url) throws Exception;
    void validateEnvironment() throws DownloadEngineException;

    interface DownloadProgressListener {
        void onDownloadProgress(String reqId, int percent, long sizeDownloaded, long totalSize);
        void onDownloadComplete(String reqId, DownloadResult result);
        void onDownloadError(String reqId, Exception error);
    }
    class DownloadEngineException extends Exception{
        public DownloadEngineException(String message){ super(message);}
        public DownloadEngineException(String message, Throwable cause){super(message);}
    }
    class VideoMetadata {
        public final String title;
        public final long durationSeconds;
        public final String thumbnailUrl;
        public final boolean isAvailable;
        public VideoMetadata(String title, long durationSeconds, String thumbnailUrl, boolean isAvailable){
            this.title = title;
            this.durationSeconds = durationSeconds;
            this.thumbnailUrl = thumbnailUrl;
            this.isAvailable = isAvailable;
        }
    }    
}