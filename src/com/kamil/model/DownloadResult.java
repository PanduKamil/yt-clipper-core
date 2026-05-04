package com.kamil.model;

public class DownloadResult {
    private final String  reqId;
    private final boolean success;
    private final String  filePath;
    private final long    fileSize;
    private final String  errorMessage;

    private DownloadResult(String reqId, boolean success, String filePath,
                            long fileSize, String errorMessage) {
        this.reqId    = reqId;
        this.success      = success;
        this.filePath     = filePath;
        this.fileSize     = fileSize;
        this.errorMessage = errorMessage;
    }

    public static DownloadResult success(String reqId, String filePath, long fileSize) {
        return new DownloadResult(reqId, true, filePath, fileSize, null);
    }

    public static DownloadResult failure(String reqId, String message) {
        return new DownloadResult(reqId, false, null, 0, message);
    }

    public String  getReqId()     { return reqId;    }
    public boolean isSuccess()        { return success;      }
    public String  getFilePath()      { return filePath;     }
    public long    getFileSize() { return fileSize;}
    public String  getErrorMessage()  { return errorMessage; }

}
