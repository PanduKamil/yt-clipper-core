package com.kamil.model;

public class DownloadResult {
    private final String  requestId;
    private final boolean success;
    private final String  filePath;
    private final long    fileSize;
    private final String  errorMessage;

    private DownloadResult(String requestId, boolean success, String filePath,
                            long fileSize, String errorMessage) {
        this.requestId    = requestId;
        this.success      = success;
        this.filePath     = filePath;
        this.fileSize     = fileSize;
        this.errorMessage = errorMessage;
    }

    public static DownloadResult success(String requestId, String filePath, long fileSize) {
        return new DownloadResult(requestId, true, filePath, fileSize, null);
    }

    public static DownloadResult failure(String requestId, String message) {
        return new DownloadResult(requestId, false, null, 0, message);
    }

    public String  getRequestId()     { return requestId;    }
    public boolean isSuccess()        { return success;      }
    public String  getFilePath()      { return filePath;     }
    public long    getFileSize() { return fileSize;}
    public String  getErrorMessage()  { return errorMessage; }

}
