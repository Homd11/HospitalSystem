public class PatientManagementSystem {
    // Attributes
    private AVLTree patientList;                 // Use AVLTree to store patients
    private WaitingList waitingList;            // Manages the priority-based waiting list
    private Billing billingRecords;// Handles billing for patients
private Queuee appointmentQueue;
    // Constructor
    public PatientManagementSystem() {
        this.patientList = new AVLTree();              // Initialize the AVLTree for storing patients
        this.waitingList = new WaitingList();          // Initialize the WaitingList
        this.billingRecords = new Billing(patientList);// Use the same AVLTree for billing
        this.appointmentQueue=patientList.PreorderApp();
    }

    // Method to add a new patient
    public void addPatient(String name, int age,String date,String time,String status,String medicalHistory,String visitrecords, String contactinfo,int per) {
        Patient newPatient = new Patient(name, age,date,time,status,medicalHistory,visitrecords,contactinfo,per);      // Create a new patient
        patientList.addPatientID(newPatient);             // Add the patient to the AVLTree
        System.out.println("Patient added successfully: " + newPatient.getName() + " (ID: " + newPatient.getPatientID() + ")");
        scheduleAppointment(newPatient.getPatientID(), date,time);
        addToWaitingList(newPatient.getPatientID());
    }


    // Method to find a patient by ID
    public Patient findPatient(int id) {
        NodeAvl node = patientList.search(id); // Search the AVLTree for the patient
        if (node != null) {
            Patient patient = node.data;
            System.out.println("Patient found: " + patient.getName() + " (ID: " + patient.getPatientID() + ")");
            return patient;
        }
        System.out.println("Patient with ID " + id + " not found.");
        return null;
    }

    // Method to schedule an appointment for a patient
    public void scheduleAppointment(int patientId, String date, String time) {
        Patient patient =findPatient(patientId);
        patient.getAppointment().schedule(date, time);

    }
    public void RescheduleAppointment(int patientId, String date, String time,int CurrentAPPOINTMENTID) {
        Patient patient =findPatient(patientId);
        patient.getAppointment().reschedule(date,time,CurrentAPPOINTMENTID);

    }
    public void cancelAppointment(int patientId,int appointmentID) {
        Patient patient =findPatient(patientId);
        patient.getAppointment().cancel(appointmentID);
    }
    public void addBillingRecord(int patientId, int amount) {
        billingRecords.addPayment(amount, patientId);
    }
    public void generateBilling(int pay,int id) {
     Patient p= findPatient(id);
     billingRecords.GenerateBill(p,pay);
    }

    public void billStatue(int id){
       Patient p =  findPatient(id);
       billingRecords.getPaymentStatus(p);
    }




    // Method to add a patient to the waiting list
    public void addToWaitingList(int patientId) {
        Patient patient = findPatient(patientId);
        if (patient != null) {
            System.out.println("Assigning priority for the patient...");
            patient.setPer(patient.getPer()); // Assuming `setPer` sets the priority for patient
            waitingList.addToWaitList(patient);
            System.out.println("Patient added to the waiting list.");
        }
    }

    // Method to generate a payment report
public void generateReport(int patientId) {
    Patient patient = findPatient(patientId);
    if (patient != null) {
        ReportGenerator reportGenerator = new ReportGenerator("patient"); // Initialize ReportGenerator
        System.out.println("Generating detailed patient report...");
        reportGenerator.generatePatientReport(patient); // Generate patient-specific report
        System.out.println("Generating billing report...");
        reportGenerator.generatePatientReport(patient); // Generate billing-specific report
        System.out.println("Generating appointment report...");
        reportGenerator.generateAppointmentReport(patient.getAppointment().single); // Generate appointment-specific report
        System.out.println("Reports generated successfully.");
    } else {
        System.out.println("Patient not found. Unable to generate reports.");
    }
}

public AVLTree sendAvl(){
        return patientList;
}




public void generateAppointmentRecord(){
    System.out.println(patientList.PreorderApp());

}

public void generateRevnue(){
ReportGenerator reportGenerator=new ReportGenerator("Revenue");
reportGenerator.generateRevenueReport();
}





public void WaitingListDisplay (){
        waitingList.PrintWaitingList();
}

















}