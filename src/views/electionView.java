package views;
import java.util.Map; 
import java.util.Scanner;
import model.candidates ;
public class electionView {
    private Scanner sc = new Scanner (System.in) ;
    public void showMainMenu(String status) {
        System.out.println("เลือกเมนูที่ต้องการ");
        System.out.println("1 voter");
        System.out.println("2 officer");
    }
    public void showOfficerMenu() {
        System.out.println("\nofficer mode");
        System.out.println("1. ปิดรับคะแนน และสแกนกลุ่มบัตรซ้ำ");
        System.out.println("2. บัตรซ้ำ");
        System.out.println("3. result");
    }

    public void showCandidates(Map<String, candidates> candidatesMap) {
        System.out.println("\ncandidate name");
        for (candidates c : candidatesMap.values()) {
            System.out.println(c.getId() + " - " + c.getName());
        }
    }

    public String getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public void showResults(Map<String, Integer> scores, Map<String, candidates> candidatesMap) {
        System.out.println("\nresult");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String cId = entry.getKey();
            String name = candidatesMap.containsKey(cId) ? candidatesMap.get(cId).getName() : "Unknown";
            System.out.println(cId + " (" + name + "): " + entry.getValue() + " คะแนน");
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
    public void showError(String errorMsg) {
        System.out.println(errorMsg);
    }
}