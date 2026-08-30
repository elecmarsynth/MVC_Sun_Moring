package controllers;

import java.util.Map;
import java.util.Scanner;
import model.ballotGroup;
import model.election;
import views.electionView;

public class electionController {
    private election model;
    private electionView view;
    private Scanner scanner;

    public electionController(election model, electionView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            view.showMainMenu(model.getStatus().toString());
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                voterMenu();
            } else if (choice.equals("2")) {
                officerMenu();
            } else if (choice.equals("0")) {
                view.showMessage("closed");
                break;
            } else {
                view.showError("try again");
            }
        }
    }

    private void voterMenu() {
        if (model.getStatus() != election.ElectionStatus.OPEN) {
            view.showError("not openf");
            return;
        }

        view.showCandidates(model.getCandidatesMap());

        try {
            String vId = view.getInput(scanner, "input Voter ID (เช่น V01): ");
            String cId = view.getInput(scanner, "input Card ID: ");
            String r1 = view.getInput(scanner, "choose no 1 (ex C01): ");
            String r2 = view.getInput(scanner, "choose no 2: ");
            String r3 = view.getInput(scanner, "choose no 3: ");

            model.castVote(cId, vId, new String[]{r1, r2, r3});
            view.showMessage("finish");
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    private void officerMenu() {
        view.showOfficerMenu();
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            model.closeElection();
            view.showMessage("close เจอกลุ่มซ้ำ" + model.getPendingGroups().length + " group");
        } else if (choice.equals("2")) {
            ballotGroup[] groups = model.getPendingGroups();
            if (groups.length == 0) {
                view.showMessage("ไม่มีบัตรค้าง");
                return;
            }
            for (int i = 0; i < groups.length; i++) {
                ballotGroup g = groups[i];
                view.showMessage("\ngroup " + (i + 1) + " Pattern: " + g.getPatternKey() + " (amount: " + g.getBallotArray().length + " ใบ)");
                String dec = view.getInput(scanner, "คำตัดสิน (1: รับรอง / 2: ไม่นับคะแนน): ");
                if (dec.equals("1")) {
                    g.setStatus("APPROVED");
                } else {
                    g.setStatus("REJECTED");
                }
            }
            model.setStatus(election.ElectionStatus.FINISHED);
            view.showMessage("FINISHED");
        } else if (choice.equals("3")) {
            if (model.getStatus() != election.ElectionStatus.FINISHED) {
                view.showError("ดูบัตรซ้ำทั้งหมดก่อน");
                return;
            }
            Map<String, Integer> scores = model.calculateResults();
            view.showResults(scores, model.getCandidatesMap());
        }
    }
}