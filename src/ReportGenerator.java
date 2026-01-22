import java.util.ArrayList;
import java.util.LinkedList;

public class ReportGenerator {
    private String reportType;
    private LinkedListSingle data; // Data for report stored using LinkedListSingle

    // Constructor
    public ReportGenerator(String reportType) {
        this.reportType = reportType;
        this.data = new LinkedListSingle(); // Initialize linked list
    }

    // Generate patient report (e.g., visit history)
    public void generatePatientReport(Patient p) {
        System.out.println("Patient Report for: " + p.getName() + " (ID: " + p.getPatientID() + ")");
        System.out.println("Medical History: " + (p.getMedicalHistory() != null ? p.getMedicalHistory() : "No records found."));
        System.out.println("Visit Records: " + (p.getVisitRecords() != null ? p.getVisitRecords() : "No visits recorded."));
        System.out.println("Contact Info: " + p.getContactInfo());
    }

    // Generate appointment report
    public void generateAppointmentReport(LinkedListSingle appointmentQueue) {
        System.out.println("\nAppointment Report:");
        if (appointmentQueue.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            appointmentQueue.display();
        }
    }

    // Generate revenue report
    public void generateRevenueReport() {
        int paid = Billing.paid;
        System.out.println("\nRevenue Report:");
        System.out.println("Total Paid: $" + paid);

    }

    // Merge Sort Algorithm
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Helper method to retrieve all patients from AVL Tree
    private LinkedList<Patient> getAllPatientsFromAVLTree(NodeAvl root) {
        LinkedList<Patient> patients = new LinkedList<>();
        traverseAVLTree(root, patients);
        return patients;
    }

    private void traverseAVLTree(NodeAvl node, LinkedList<Patient> patients) {
        if (node != null) {
            traverseAVLTree(node.left, patients);
            patients.add(node.data);       // Collect patient data
            traverseAVLTree(node.right, patients);
        }
    }
}