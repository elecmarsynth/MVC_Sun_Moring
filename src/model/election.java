package model;
import java.io.*;
import java.util.*;

public class election {
    public enum ElectionStatus { OPEN, CLOSED, FINISHED }
    
    private ElectionStatus status = ElectionStatus.OPEN;
    private Map<String, candidates> candidatesMap = new HashMap<>();
    private Map<String, voters> votersMap = new HashMap<>();
    private ballots[] ballotsArr = new ballots[0];
    private ballotGroup[] pendingGroups = new ballotGroup[0];

    public election() {
        for (int i = 1; i <= 7; i++) {
            String id = String.format("V%02d", i);
            votersMap.put(id, new voters(id));
        }
        loadCandidatesFromCSV("candidates.csv");
        loadBallotsFromCSV("ballots.csv");
    }

    private void loadCandidatesFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",", -1);
                if (data.length >= 2) {
                    candidatesMap.put(data[0].trim(), new candidates(data[0].trim(), data[1].trim()));
                }
            }
        } catch (Exception e){}
    }

    private void loadBallotsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",", -1);
                if (data.length >= 5) {
                    String[] choose = { data[2].trim(), data[3].trim(), data[4].trim() };
                    castVote(data[0].trim(), data[1].trim(), choose);
                }
            }
        } catch (Exception e) {}
    }

    public void castVote(String cardId, String voterId, String[] choices) throws Exception {
        if (status != ElectionStatus.OPEN) throw new Exception("Not Open");
        if (!votersMap.containsKey(voterId)) throw new Exception("not found voter");
        if (votersMap.get(voterId).getHasVote()) throw new Exception("already vote");
        
        if (choices.length < 3 || choices[0].isEmpty() || choices[1].isEmpty() || choices[2].isEmpty()) {
            throw new Exception("choose 3 rank");
        }
        
        Set<String> checkDuplicate = new HashSet<>(Arrays.asList(choices));
        if (checkDuplicate.size() < 3) throw new Exception("ห้ามเลือกซ้ำน้า");

        for (String cId : choices) {
            if (!candidatesMap.containsKey(cId)) throw new Exception("ไม่พบ: " + cId);
        }
        ballots newBallot = new ballots(cardId, voterId, choices, "ACCEPTED");
        ballotsArr = Arrays.copyOf(ballotsArr, ballotsArr.length + 1);
        ballotsArr[ballotsArr.length - 1] = newBallot;
        
        votersMap.get(voterId).setHasVote(true);
    }

    public void closeElection() {
        this.status = ElectionStatus.CLOSED;
        Map<String, List<ballots>> patternMap = new HashMap<>();

        for (ballots b : ballotsArr) {
            patternMap.computeIfAbsent(b.getPatternKey(), k -> new ArrayList<>()).add(b);
        }

        pendingGroups = new ballotGroup[0]; // Reset array
        for (Map.Entry<String, List<ballots>> entry : patternMap.entrySet()) {
            if (entry.getValue().size() >= 3) {
                ballotGroup group = new ballotGroup(entry.getKey());
                for (ballots b : entry.getValue()) {
                    group.addBallot(b);
                }
                pendingGroups = Arrays.copyOf(pendingGroups, pendingGroups.length + 1);
                pendingGroups[pendingGroups.length - 1] = group;
            }
        }
    }

    public Map<String, Integer> calculateResults() {
        Map<String, Integer> scores = new HashMap<>();
        for (candidates c : candidatesMap.values()) scores.put(c.getId(), 0);

        for (ballots b : ballotsArr) {
            if (b.getStatus().equals("ACCEPTED") || b.getStatus().equals("APPROVED")) {
                String[] choices = b.getChooseCandidate();
                scores.put(choices[0], scores.getOrDefault(choices[0], 0) + 3);
                scores.put(choices[1], scores.getOrDefault(choices[1], 0) + 2);
                scores.put(choices[2], scores.getOrDefault(choices[2], 0) + 1);
            }
        }
        return scores;
    }

    public ElectionStatus getStatus() { 
        return status; 
    }
    public void setStatus(ElectionStatus status) { 
        this.status = status; 
    }
    public Map<String, candidates> getCandidatesMap() { 
        return candidatesMap; 
    }
    public ballots[] getBallotsArr() { 
        return ballotsArr; 
    }
    public ballotGroup[] getPendingGroups() { 
        return pendingGroups; 
    }
}