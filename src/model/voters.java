package model;
public class voters {
    private String voteId;
    private boolean hasVote ;

    public voters(String voteId , boolean hasVote) {
        this.voteId = voteId ;
        this.hasVote = false ;
    }
    public voters(String voteId ) {
        this.voteId = voteId ;
    }
    public String getVoteId(){
        return this.voteId ;
    }
    public boolean getHasVote(){
        return this.hasVote ;
    }
    public void setVoteId(String voteId){
        this.voteId = voteId ;
    }
    public void setHasVote(boolean hasVote){
        this.hasVote = hasVote ;
    }


    
}
