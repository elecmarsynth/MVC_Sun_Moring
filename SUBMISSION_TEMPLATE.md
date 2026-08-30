# SUBMISSION - Exit Exam MVC 1/2569 (อาทิตย์เช้า)

## 1. วิธีเปิดโปรแกรม
- java 
- Entry point / คำสั่งเปิดโปรแกรม: run file main หรือ javac Main.java java Main
- หมายเหตุที่จำเป็น (ถ้ามี): 

## 2. ตารางเชื่อมโยง Requirements

| Requirement | Model / Domain | Controller / Action | View / Screen |
|---|---|---|---|
| R1 | election.java,candidates.java,voters.java, ballots.java, ballotGroup.java | electionController.java` | `electionView.java`, `Main.java` |
| R2 | `election.castVote()` (เช็คสิทธิ์ซ้ำ T2, เลือกซ้ำ T3, สถานะ OPEN) | `electionController.processVote()` | `electionView.showVoterMenu()`, `showError()` |
| R3 | `election.closeElection()` (จัดกลุ่มบัตรซ้ำ $\ge 3$ ใบ) | `electionController.closeElection()` | `electionView.showPendingGroups()` |
| R4 | `ballotGroup.setStatus()`, `election.calculateResults()` | `electionController.decideGroup()` | `electionView.showDecisionMenu()` |
| R5 | `election.getStatus()`, `election.getBallots()` | `electionController.showStatus()`|`electionViewshowFinalResults()`, `showError()` |

## 3. ผลการทดสอบ

| กรณี | ผ่าน/ไม่ผ่าน | หมายเหตุ (เฉพาะที่จำเป็น) |
|---|---|---|
| T1 | ผ่าน | อ่านและโหลดข้อมูล candidates.csv และ ballots.csv เข้าระบบสำเร็จ |
| T2 | ผ่าน | ปฏิเสธการโหวตเมื่อใช้ Voter ID ที่เคยลงคะแนนไปแล้ว |
| T3 | ผ่าน | ปฏิเสธการโหวตเมื่อเลือกผู้สมัครซ้ำกันในบัตรใบเดียวกัน (เช่น C04 > C04 > C02) |
| T4 | ผ่าน | ระบบปิดรับคะแนนและจัดกลุ่มบัตรที่มี pattern ซ้ำกัน $\ge 3$ ใบเข้าสู่สถานะรอตรวจได้ถูกต้อง |
| T5 | ผ่าน | เจ้าหน้าที่สามารถอนุมัติ (APPROVED) หรือปฏิเสธ (REJECTED) กลุ่มบัตรซ้ำได้ตามเงื่อนไข |
| T6 | ผ่าน | คำนวณคะแนนรวมถ่วงน้ำหนัก (3-2-1) เฉพาะบัตรที่รับรองแล้วและแสดงผลสรุปได้ถูกต้อง |

## 4. ความแตกต่างระหว่างแบบที่ออกกับโปรแกรมจริง (ถ้ามี)
ระบุไม่เกิน 3 ข้อ
1. 
2. 
3. 

## 5. บันทึกการใช้ Generative AI
หากไม่ได้ใช้ ให้ระบุ **ไม่ได้ใช้ Generative AI**

| เวลาโดยประมาณ | เครื่องมือ | ใช้เพื่ออะไร | นำคำแนะนำไปใช้อย่างไร |
|10.38|gemini|ศึกษาวิธีการเพิ่มข้อมูลในภาษา java แบบ file csv|นำโครงทีไ่ด้มาเปลี่ยนแปลง และอ่านไฟล์ csv|
|11.45|gemini|สอบถามแนวคิดและขอโค้ดตัวอย่างสำหรับ Logic R1-R5 และระบบ MVC|นำโครงสร้าง MVC และ Business Rules (T2, T3, ถ่วงน้ำหนักคะแนน) มาปรับใช้|
|11.48|gemini|แก้ไขข้อผิดพลาดของการคอมไพล์ (Case Sensitivity และ Package Import Error)|ปรับชื่อคลาสและเพิ่ม Import Package ให้ถูกต้องตรงตามโฟลเดอร์|
