package model;
import java.util.Arrays;

public class ballotGroup {
    private String patternKey;
    private ballots[] ballotArray = new ballots[0];
    private String status;

    public ballotGroup(String patternKey) {
        this.patternKey = patternKey;
        this.status = "PENDING";
    }

    public void addBallot(ballots b) {
        ballotArray = Arrays.copyOf(ballotArray, ballotArray.length + 1);
        ballotArray[ballotArray.length - 1] = b;
    }

    public ballots[] getBallotArray() { return ballotArray; }
    public String getPatternKey() { return patternKey; }
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status;
        for (ballots b : ballotArray) {
            b.setStatus(status);
        }
    }
}