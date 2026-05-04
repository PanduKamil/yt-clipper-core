package com.kamil.model;

import java.util.UUID;

public final class ClipRequest {

    private final String reqId;
    private final String startTime;
    private final String endTime;
    private final String outputName;
    private final String inputPath;

    private ClipRequest(Builder builder){
        this.reqId  = builder.reqId != null ? builder.reqId : UUID.randomUUID().toString().substring(0, 8);
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.outputName = builder.outputName;
        this.inputPath = builder.inputPath;
    }
    //getter
    public String getReqId(){ return reqId;}
    public String getStartTime(){ return startTime;}
    public String getEndTime(){return endTime;}
    public String getOutputName(){return outputName;}
    public String getInputPath(){return inputPath;}
    //wither
    public ClipRequest withInputPath(String path){
            return new Builder()
                    .reqId(this.reqId)
                    .startTime(this.startTime)
                    .endTime(this.endTime)
                    .outputName(this.outputName)
                    .inputPath(path)
                    .build();
    }
    @Override
    public String toString(){
        return "Detail data clip : id= " + reqId 
                + ", start clip= " + startTime
                + ", end clip= " + endTime
                + ", outputClip= " + outputName;
    }


    public static final class Builder{
        private String reqId;
        private String startTime;
        private String endTime;
        private String outputName;
        private String inputPath;

        public Builder reqId(String b)  {this.reqId = b; return this;}
        public Builder startTime(String b) {this.startTime = b; return this;}
        public Builder endTime(String b) {this.endTime = b; return this;}
        public Builder outputName(String b) {this.outputName = b; return this;}
        public Builder inputPath(String b) {this.inputPath = b; return this;}

        public ClipRequest build(){
            if (startTime == null || endTime == null) {
                throw new IllegalStateException("startTime and endtime are required");
            }
            return new ClipRequest(this);
        }
    }
}