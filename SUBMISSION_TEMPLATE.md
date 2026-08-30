# SUBMISSION - Exit Exam MVC 1/2569 (อาทิตย์เช้า)

## 1. วิธีเปิดโปรแกรม
- ภาษาที่ใช้ : java
- Entry point / คำสั่งเปิดโปรแกรม: run file main หรือ javac Main.java java Main
- หมายเหตุที่จำเป็น (ถ้ามี): 

## 2. ตารางเชื่อมโยง Requirements

| Requirement | Model / Domain | Controller / Action | View / Screen |
|---|---|---|---|
| R1 | election.java, candidates.java , voters.java, ballots.java, ballotGroup.java | electionController.java | electionView.java, Main.java |
| R2 | election.castVote()| electionController.voterMenu() | electionView.showCandidates(), showError() |
| R3 | election.closeElection()  | electionController.officerMenu() | electionView.showMessage() |
| R4 | ballotGroup.setStatus(), election.calculateResults() | electionController.officerMenu() | electionView.getInput(), showOfficerMenu() |
| R5 | election.getStatus(), election.getBallotsArr() | electionController.officerMenu() | electionView.showResults(), showError() |

## 3. ผลการทดสอบ

| กรณี | ผ่าน/ไม่ผ่าน | หมายเหตุ (เฉพาะที่จำเป็น) |
|---|---|---|
| T1 | ผ่าน | |
| T2 | ผ่าน | |
| T3 | ผ่าน | |
| T4 | ผ่าน | |
| T5 | ผ่าน | |
| T6 | ผ่าน | |

## 4. ความแตกต่างระหว่างแบบที่ออกกับโปรแกรมจริง (ถ้ามี)
ระบุไม่เกิน 3 ข้อ
1. 
2. 
3. 

## 5. บันทึกการใช้ Generative AI
หากไม่ได้ใช้ ให้ระบุ **ไม่ได้ใช้ Generative AI**

| เวลาโดยประมาณ | เครื่องมือ | ใช้เพื่ออะไร | นำคำแนะนำไปใช้อย่างไร |
|10.38|gemini|ศึกษาวิธีการเพิ่มข้อมูลในภาษา java แบบ file csv|นำโครงทีไ่ด้มาเปลี่ยนแปลง และอ่านไฟล์ csv|
|11.45|gemini|สอบถามแนวคิด R1-R5 |นำโครงสร้าง ไปเขียนในรูป MVC และ นำ requirement มาทำเขียนเป็น logic ใน code|
|11.48|gemini|แก้ไขข้อผิดพลาดของการคอมไพล์ (Package Import Error)|เพิ่ม Import Package ให้กับทุกไฟล์|
