package banquemisr.challenge05.system.models.responses;

public class BasicResponseModel{
    private String replyCode;
    private String replyMsg;

    public String getReplyCode() {
        return replyCode;
    }

    public String getReplyMsg() {
        return replyMsg;
    }

    private BasicResponseModel(BasicResponseBuilderModel builder){
        this.replyCode = builder.replyCode;
        this.replyMsg= builder.replyMsg;
    }

    public static class BasicResponseBuilderModel{
        private String replyCode;
        private String replyMsg;

        public BasicResponseBuilderModel(){

        }

        public BasicResponseBuilderModel(String replyCode, String replyMsg){
            this.replyCode = replyCode;
            this.replyMsg = replyMsg;
        }

        public BasicResponseBuilderModel setReplyCode(String replyCode){
            this.replyCode = replyCode;
            return this;
        }

        public BasicResponseBuilderModel setReplyMsg(String replyMsg){
            this.replyMsg = replyMsg;
            return this;
        }

        public BasicResponseModel build(){
            return new BasicResponseModel(this);
        }
    }
}
