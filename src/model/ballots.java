package model;
public class ballots {
    private String cardId ;
    private String voteId ;
    private String[] chooseCandidate = new String[3];
    private String status ;

    public ballots(String cardId, String voteId,String[] chooseCandidate , String status) {
        this.cardId = cardId;
        this.voteId = voteId;
        this.chooseCandidate = chooseCandidate ;
        this.status = status;
    }
    public String getVoteId(){
        return this.voteId ;
    }
    public String getcardId(){
        return this.cardId ;
    }
    public String getStatus(){
        return this.status ;
    }
    public String[] getChooseCandidate(){
        return chooseCandidate ;
    }
    public void setVoteId(String voteId){
        this.voteId = voteId ;
    }
    public void setStatus(String status){
        this.status = status ;
    }
    public String getPatternKey() {
        return chooseCandidate[0] + "-" + chooseCandidate[1] + "-" + chooseCandidate[2];
    }
}
