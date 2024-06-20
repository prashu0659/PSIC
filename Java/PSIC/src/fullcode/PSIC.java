import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class PSIC {
    private static List<Physician> physicians = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static List<Treatment> treatments = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeClinicData();
        boolean quit = false;
        while (!quit) {
            System.out.println("\n------------------------------------------------------");
            System.out.println("\nWELCOME TO PHYSIOTHERAPY & SPORTS INJURY CENTRE(PSIC)");
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n1) Patient Information");
            System.out.println("2) Physician Information");
            System.out.println("3) Appointments");
            System.out.println("4) Reports");
            System.out.println("5) Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    managePhysicians();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void managePatients() {
        boolean back = false;
        while (!back) {
            System.out.println("\nPatient Information Menu:");
            System.out.println("1) Add Patient");
            System.out.println("2) Remove Patient");
            System.out.println("3) View All Patients");
            System.out.println("4) Back to Main Menu");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
    
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    removePatient();
                    break;
                case 3:
                    viewAllPatients();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    
    private static void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        
        System.out.println("\nList of all registered patients:");
    printPatientTableHeader();  // Ensure this method is being called here
    for (Patient patient : patients) {
        printPatientTableRow(patient.getId(), patient.getFullName(), patient.getAddress(), patient.getTelephone());
    }
    }

    private static void printPatientTableHeader() {
        System.out.printf("%-5s %-20s %-50s %-15s%n", "ID", "Name", "Address", "Phone");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private static void printPatientTableRow(int id, String name, String address, String phone) {
        System.out.printf("%-5d %-20s %-50s %-15s%n", id, name, address, phone);
    }

    private static void managePhysicians() {
        boolean back = false;
        while (!back) {
            System.out.println("Physician Information Menu:");
            System.out.println("1) Add Physician");
            System.out.println("2) Remove Physician");
            System.out.println("3) View All Physicians");
            System.out.println("4) Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPhysician();
                    break;
                case 2:
                    removePhysician();
                    break;
                case 3:
                    viewAllPhysicians();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    

    private static void viewAllPhysicians() {
        if (physicians.isEmpty()) {
            System.out.println("No physicians found.");
            return;
        }
        
        System.out.println("\nList of all registered physicians:");
        printPhysiciansTableHeader();
        for (Physician physician : physicians) {
            printPhysicianTableRow(physician.getId(), physician.getFullName(), physician.getAddress(), physician.getTelephone(), String.join(", ", physician.getExpertise()));
        }
    }
    
    private static void printPhysiciansTableHeader() {
        System.out.printf("%-5s %-20s %-50s %-15s %-30s%n", "ID", "Name", "Address", "Phone", "Expertise");
        System.out.println("--------------------------------------------------------------------------------------------------------------------- ");
    }
    
    private static void printPhysicianTableRow(int id, String name, String address, String phone, String expertise) {
        System.out.printf("%-5d %-20s %-50s %-15s %-30s%n", id, name, address, phone, expertise);
    }
    
    
    private static void manageAppointments() {
        boolean back = false;
        while (!back) {
            System.out.println("\nAppointment Management Menu:");
            System.out.println("1) Book Appointment");
            System.out.println("2) Reschedule Appointment");
            System.out.println("3) Cancel Appointment");
            System.out.println("4) Mark Appointment As Attended");
            System.out.println("5) View Appointments");
            System.out.println("6) Back to Main Menu");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    bookAppointmentMenu();
                    break;
                case 2:
                    rescheduleAppointment();
                    break;
                case 3:
                    cancelAppointment();
                    break;
                case 4:
                    markAppointmentAsAttended();
                    break;
                case 5:
                    viewAppointments();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    
    private static void bookAppointmentMenu() {
        System.out.println("\nBooking Options:");
        System.out.println("1) Book by Expertise");
        System.out.println("2) Book by Physician Name");
        System.out.println("3) Back");
    
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                lookupByExpertiseAndBook();
                break;
            case 2:
                lookupByPhysicianAndBook();
                break;
            case 3:
                return; // Simply return to the previous menu
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void lookupByExpertiseAndBook() {
        System.out.println("\nEnter the area of expertise you're interested in (e.g., Cardiology, Neurology):");
        String expertise = scanner.nextLine();
        
        List<Treatment> availableTreatments = treatments.stream()
            .filter(t -> t.getExpertise().contains(expertise))  // Filter treatments by expertise
            .collect(Collectors.toList());
    
        if (availableTreatments.isEmpty()) {
            System.out.println("No treatments available for this expertise.");
            return;
        }
    
        System.out.println("Available treatments and times:");
        availableTreatments.forEach(t ->
            System.out.println("Treatment: " + t.getName() + 
                               " offered by " + t.getResponsiblePhysician().getFullName() + 
                               " in room " + t.getRoom().getRoomName() + 
                               " at times " + t.getAvailableTimes())
        );
    
        System.out.println("Enter the name of the treatment you would like to book:");
        String treatmentName = scanner.nextLine();
        Optional<Treatment> selectedTreatment = availableTreatments.stream()
            .filter(t -> t.getName().equalsIgnoreCase(treatmentName))
            .findFirst();
    
        if (!selectedTreatment.isPresent()) {
            System.out.println("Treatment not found, please try again.");
            return;
        }
    
        System.out.println("Available times: " + selectedTreatment.get().getAvailableTimes());
        System.out.println("Enter the time you want to book (HH:mm):");
        String chosenTime = scanner.nextLine();
    
        // Validate the chosen time
        if (!selectedTreatment.get().getAvailableTimes().contains(chosenTime)) {
            System.out.println("Invalid time selected, please choose one of the available times.");
            return;
        }
    
        // Ask for patient details
        System.out.println("Enter your full name:");
        String patientName = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();
    
        // Creating patient object
        int newId = patients.stream().mapToInt(Patient::getId).max().orElse(200) + 1;
        Patient patient = new Patient(newId, patientName, "Unknown Address", phoneNumber);
        patients.add(patient);
    
        // Booking the appointment
        LocalDateTime appointmentTime = LocalDateTime.now().withHour(Integer.parseInt(chosenTime.split(":")[0]))
                                                          .withMinute(Integer.parseInt(chosenTime.split(":")[1]))
                                                          .withSecond(0)
                                                          .withNano(0);
        LocalDateTime endTime = appointmentTime.plusHours(1); // Assuming 1-hour duration
    
        Appointment newAppointment = new Appointment(patient, selectedTreatment.get(), appointmentTime, endTime, selectedTreatment.get().getRoom(), "Booked");
        appointments.add(newAppointment);
    
        System.out.println("Appointment booked successfully for: " + patientName);
        System.out.println("Details: " + newAppointment);
    }

    private static void lookupByPhysicianAndBook() {
    System.out.println("\nEnter the name of the physician you're looking for:");
    String physicianName = scanner.nextLine();

    // Filter treatments by the physician's name
    List<Treatment> availableTreatments = treatments.stream()
        .filter(t -> t.getResponsiblePhysician().getFullName().equalsIgnoreCase(physicianName))
        .collect(Collectors.toList());

    if (availableTreatments.isEmpty()) {
        System.out.println("No treatments available with this physician.");
        return;
    }

    System.out.println("Available treatments by " + physicianName + ":");
    availableTreatments.forEach(t -> 
        System.out.println("Treatment: " + t.getName() +
                           ", Room: " + t.getRoom().getRoomName() +
                           ", Times: " + t.getAvailableTimes())
    );

    System.out.println("Enter the name of the treatment you would like to book:");
    String treatmentName = scanner.nextLine();
    Optional<Treatment> selectedTreatment = availableTreatments.stream()
        .filter(t -> t.getName().equalsIgnoreCase(treatmentName))
        .findFirst();

    if (!selectedTreatment.isPresent()) {
        System.out.println("Treatment not found, please try again.");
        return;
    }

    // Displaying available times for the selected treatment
    System.out.println("Available times for " + selectedTreatment.get().getName() + ": " + selectedTreatment.get().getAvailableTimes());
    System.out.println("Enter the time you would like to book (HH:mm):");
    String chosenTime = scanner.nextLine();

    // Checking if the chosen time is in the list of available times
    if (!selectedTreatment.get().getAvailableTimes().contains(chosenTime)) {
        System.out.println("Selected time is not available, please choose a valid time.");
        return;
    }

    // Proceed to get patient details and book the appointment
    System.out.println("Enter your full name:");
    String patientName = scanner.nextLine();
    System.out.println("Enter your address:");
    String address = scanner.nextLine();
    System.out.println("Enter your telephone number:");
    String telephone = scanner.nextLine();

    Optional<Patient> existingPatient = patients.stream()
        .filter(p -> p.getFullName().equalsIgnoreCase(patientName))
        .findFirst();

    Patient patient = existingPatient.orElseGet(() -> {
        int newId = patients.stream().mapToInt(Patient::getId).max().orElse(200) + 1;
        Patient newPatient = new Patient(newId, patientName, address, telephone);
        patients.add(newPatient);
        return newPatient;
    });

    LocalDateTime startTime = LocalDateTime.parse(LocalDate.now() + "T" + chosenTime);
    LocalDateTime endTime = startTime.plusHours(1);  // Assuming 1 hour duration

    Room treatmentRoom = selectedTreatment.get().getRoom();
    Appointment newAppointment = new Appointment(patient, selectedTreatment.get(), startTime, endTime, treatmentRoom, "Booked");
    appointments.add(newAppointment);
    System.out.println("Appointment booked successfully for " + patientName + ":\n" + newAppointment);
}

    private static void generateReports() {
        boolean back = false;
        while (!back) {
            System.out.println("Reports Menu:");
            System.out.println("1) Generate Physician Report");
            System.out.println("2) Generate Patient Report");
            System.out.println("3) Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    generatePhysicianReport();
                    break;
                case 2:
                    generatePatientReport();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void initializeClinicData() {
        // Sample data for physicians
        physicians.add(new Physician(101, "Dr. Smith", "123 Abbey Road, London NW8 9AY", "555-0101",
            Arrays.asList("Neurology", "Acupuncture"), Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)));

        physicians.add(new Physician(102, "Dr. Jones", "124 Baker Street, London W1U 6TQ", "555-0202",
            Arrays.asList("Orthopedics", "Rehabilitation"), Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY)));

        physicians.add(new Physician(103, "Dr. White", "125 Piccadilly, London W1J 9HS", "555-0303",
            Arrays.asList("Neurology", "Acupuncture"), Arrays.asList(DayOfWeek.WEDNESDAY)));

        physicians.add(new Physician(104, "Dr. Black", "126 Fleet Street, London EC4A 2DQ", "555-0404",
            Arrays.asList("Massage", "Orthopedics"), Arrays.asList(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)));

        physicians.add(new Physician(105, "Dr. Green", "127 High Street, Oxford OX1 4DD", "555-0505",
            Arrays.asList("Rehabilitation", "Massage"), Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY)));

        // Sample data for patients
        patients.add(new Patient(201, "John Doe", "789 King’s Road, Chelsea, London SW3 5XP", "9876543210"));
        patients.add(new Patient(202, "Jane Doe", "788 Strand, London WC2R 0EW", "1234567890"));
        patients.add(new Patient(203, "Jim Beam", "787 Portobello Road, London W11 2DY", "5551234567"));
        patients.add(new Patient(204, "Jack Daniels", "786 Brick Lane, London E1 6QL", "9998887777"));
        patients.add(new Patient(205, "Johnny Walker", "785 Pudding Lane, London EC3R 8AB", "8005551234"));
        patients.add(new Patient(206, "Sarah Connor", "784 Electric Avenue, London SW9 8LA", "7776665555"));
        patients.add(new Patient(207, "James Bond", "783 Pall Mall, London SW1Y 5ES", "3332221111"));
        patients.add(new Patient(208, "Bruce Wayne", "782 Abbey Road, London NW8 9AY", "1231231234"));
        patients.add(new Patient(209, "Clark Kent", "781 Cornhill, London EC3V 3ND", "4564564567"));
        patients.add(new Patient(210, "Peter Parker", "780 Downing Street, London SW1A 2AA", "3213214321"));
        patients.add(new Patient(211, "Tony Stark", "779 Oxford Street, London W1D 1BS", "6546547654"));
        patients.add(new Patient(212, "Bruce Banner", "778 Regent Street, London W1B 5RL", "7897890987"));
        patients.add(new Patient(213, "Steve Rogers", "777 King’s Cross, London N1C 4AP", "8768769876"));
        patients.add(new Patient(214, "Natasha Romanoff", "776 Canary Wharf, London E14 5AB", "1122334455"));
        patients.add(new Patient(215, "Wanda Maximoff", "775 Victoria Street, London SW1H 0HW", "2233445566"));

        // Sample data for treatments and appointments
        Room consultingSuiteA = new Room("201", "Consulting Suite A");
        Room consultingSuiteB = new Room("202", "Consulting Suite B");
        Room consultingSuiteC = new Room("203", "Consulting Suite C");
        Room swimmingPool = new Room("204", "Swimming Pool");
        Room gym = new Room("205", "Gym");

        // Assuming each treatment has predefined available times and specific expertise areas
Treatment neuralMobilisation = new Treatment(
    "Neural Mobilisation", 
    physicians.get(2), 
    consultingSuiteA, 
    Arrays.asList("09:00", "10:00"),  // Schedule times
    Arrays.asList("10:00", "11:00"),  // Available times for booking
    "Neurology"                       // Expertise
);

Treatment acupuncture = new Treatment(
    "Acupuncture", 
    physicians.get(1), 
    consultingSuiteB, 
    Arrays.asList("11:00", "12:00"),  // Schedule times
    Arrays.asList("12:00", "13:00"),  // Available times for booking
    "Traditional Chinese Medicine"    // Expertise
);

Treatment massage = new Treatment(
    "Massage", 
    physicians.get(0), 
    consultingSuiteC, 
    Arrays.asList("13:00", "14:00"),  // Schedule times
    Arrays.asList("14:00", "15:00"),  // Available times for booking
    "Therapeutic Massage"             // Expertise
);

Treatment spineMobilisation = new Treatment(
    "Mobilisation of the Spine and Joints", 
    physicians.get(1), 
    gym, 
    Arrays.asList("15:00", "16:00"),  // Schedule times
    Arrays.asList("16:00", "17:00"),  // Available times for booking
    "Orthopedics"                     // Expertise
);

Treatment poolRehab = new Treatment(
    "Pool Rehabilitation", 
    physicians.get(2), 
    swimmingPool, 
    Arrays.asList("17:00", "18:00"),  // Schedule times
    Arrays.asList("18:00", "19:00"),  // Available times for booking
    "Rehabilitation"                  // Expertise
);


        treatments.add(neuralMobilisation);
        treatments.add(acupuncture);
        treatments.add(massage);
        treatments.add(spineMobilisation);
        treatments.add(poolRehab);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = now.minusDays(1);
        LocalDateTime endTime = startTime.plusHours(1);  // assuming a duration of 1 hour
        appointments.add(new Appointment(patients.get(0), neuralMobilisation, startTime, endTime, neuralMobilisation.getRoom(), "Booked"));
        LocalDateTime startTime1 = now.minusDays(4).withHour(10).withMinute(0);
        LocalDateTime endTime1 = startTime1.plusHours(1);  // 1-hour duration
        appointments.add(new Appointment(patients.get(1), acupuncture, startTime1, endTime1, acupuncture.getRoom(), "Attended"));

        LocalDateTime startTime2 = now.minusDays(2).withHour(14).withMinute(30);
        LocalDateTime endTime2 = startTime2.plusHours(1);
        appointments.add(new Appointment(patients.get(2), massage, startTime2, endTime2, massage.getRoom(), "Cancelled"));

        LocalDateTime startTime3 = now.minusDays(3).withHour(9).withMinute(15);
        LocalDateTime endTime3 = startTime3.plusHours(1);
        appointments.add(new Appointment(patients.get(3), spineMobilisation, startTime3, endTime3, spineMobilisation.getRoom(), "Booked"));

        LocalDateTime startTime4 = now.minusDays(1).withHour(16).withMinute(0);
        LocalDateTime endTime4 = startTime4.plusHours(1);
        appointments.add(new Appointment(patients.get(4), poolRehab, startTime4, endTime4, poolRehab.getRoom(), "Rescheduled"));

        LocalDateTime startTime5 = now.plusDays(1).withHour(11).withMinute(30);
        LocalDateTime endTime5 = startTime5.plusHours(1);
        appointments.add(new Appointment(patients.get(5), neuralMobilisation, startTime5, endTime5, neuralMobilisation.getRoom(), "Booked"));
        System.out.println("Clinic data initialized.");
    }

    // Implement methods such as addPatient, removePatient, addPhysician, removePhysician, etc.
    // Also, provide the implementations for bookAppointment, rescheduleAppointment, cancelAppointment,
    // markAppointmentAsAttended, viewAppointments, generatePhysicianReport, and generatePatientReport.

    private static void addPatient() {
        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Patient Address:");
        String address = scanner.nextLine();
        
        String telephone;
        while (true) {
            System.out.println("Enter Patient Telephone (10 digits):");
            telephone = scanner.nextLine();
            if (isValidPhoneNumber(telephone)) {
                break;
            } else {
                System.out.println("Invalid telephone number. Please enter a valid 10-digit phone number.");
            }
        }
        
        int newId = patients.stream().mapToInt(Patient::getId).max().orElse(200) + 1;
        Patient newPatient = new Patient(newId, name, address, telephone);
        patients.add(newPatient);
        System.out.println("Added new patient: " + newId +" " + name);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // This regex checks for exactly 10 digits
        String phoneRegex = "\\d{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }

    private static void removePatient() {
        System.out.println("Enter Patient ID to remove:");
        int id = scanner.nextInt();
        if (patients.removeIf(p -> p.getId() == id)) {
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
    private static void viewAppointments() {
        System.out.println("All Appointments:");
        if (appointments.isEmpty()) {
            System.out.println("No appointments to display.");
            return;
        }
    
        printTableHeader("Patient", "Treatment", "Physician", "Date", "Time", "Status");
        for (Appointment appointment : appointments) {
            Patient patient = appointment.getPatient();
            Treatment treatment = appointment.getTreatment();
            LocalDateTime dateTime = appointment.getDateTime();
            String status = appointment.getStatus();
    
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
            printTableRow(patient.getFullName(),
                          treatment.getName(),
                          treatment.getResponsiblePhysician().getFullName(),
                          dateTime.toLocalDate().format(dateFormatter),
                          dateTime.toLocalTime().format(timeFormatter),
                          status);
        }
    }
    
    private static void addPhysician() {
        System.out.println("Enter Physician Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Physician Address:");
        String address = scanner.nextLine();
        System.out.println("Enter Physician Telephone:");
        String telephone = scanner.nextLine();
        System.out.println("Enter Physician Expertise (comma-separated):");
        String expertiseInput = scanner.nextLine();
        List<String> expertise = Arrays.asList(expertiseInput.split(","));
        int newId = physicians.stream().mapToInt(Physician::getId).max().orElse(100) + 1;
        Physician newPhysician = new Physician(newId, name, address, telephone, expertise);
        physicians.add(newPhysician);
        System.out.println("Added new physician: " + newPhysician);
    }

    private static void removePhysician() {
        System.out.println("Enter Physician ID to remove:");
        int id = scanner.nextInt();
        if (physicians.removeIf(p -> p.getId() == id)) {
            System.out.println("Physician removed successfully.");
        } else {
            System.out.println("Physician not found.");
        }
    }

        private static void rescheduleAppointment() {
        System.out.println("Enter Patient Name to reschedule:");
        String patientName = scanner.nextLine();
        List<Appointment> patientAppointments = appointments.stream()
            .filter(a -> a.getPatient().getFullName().equals(patientName))
            .collect(Collectors.toList());
        if (patientAppointments.isEmpty()) {
            System.out.println("No appointments found for " + patientName);
            return;
        }
        patientAppointments.forEach(a -> System.out.println("Appointment: " + a.getTreatment().getName() + " at " + a.getDateTime()));
    
        System.out.println("Enter Treatment Name to reschedule:");
        String treatmentName = scanner.nextLine();
        Optional<Appointment> appointment = patientAppointments.stream()
            .filter(a -> a.getTreatment().getName().equals(treatmentName))
            .findFirst();
        if (!appointment.isPresent()) {
            System.out.println("Appointment not found.");
            return;
        }
        System.out.println("Enter new date and time for the start of the appointment (format: yyyy-MM-ddTHH:mm):");
        String newDateTimeInput = scanner.nextLine();
        LocalDateTime newStartDateTime;
        try {
            newStartDateTime = LocalDateTime.parse(newDateTimeInput);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }
        LocalDateTime newEndDateTime = newStartDateTime.plusHours(1); // Assuming a fixed duration of 1 hour for all appointments
        appointment.get().setStartDateTime(newStartDateTime);
        appointment.get().setEndDateTime(newEndDateTime);
        System.out.println("Appointment rescheduled to " + newStartDateTime);
    }    

    private static void cancelAppointment() {
        System.out.println("Enter Patient Name to cancel appointment:");
        String patientName = scanner.nextLine();
        List<Appointment> patientAppointments = appointments.stream()
            .filter(a -> a.getPatient().getFullName().equals(patientName))
            .collect(Collectors.toList());
        if (patientAppointments.isEmpty()) {
            System.out.println("No appointments found for " + patientName);
            return;
        }
        patientAppointments.forEach(a -> System.out.println("Appointment: " + a.getTreatment().getName() + " at " + a.getDateTime()));
        System.out.println("Enter Treatment Name to cancel:");
        String treatmentName = scanner.nextLine();
        Optional<Appointment> appointment = patientAppointments.stream()
            .filter(a -> a.getTreatment().getName().equals(treatmentName))
            .findFirst();
        if (!appointment.isPresent()) {
            System.out.println("Appointment not found.");
            return;
        }
        appointments.remove(appointment.get());
        System.out.println("Appointment cancelled for " + treatmentName);
    }

    private static void markAppointmentAsAttended() {
        System.out.println("Enter Patient Name to mark appointment as attended:");
        String patientName = scanner.nextLine();
        List<Appointment> patientAppointments = appointments.stream()
            .filter(a -> a.getPatient().getFullName().equals(patientName))
            .collect(Collectors.toList());
        if (patientAppointments.isEmpty()) {
            System.out.println("No appointments found for " + patientName);
            return;
        }
        patientAppointments.forEach(a -> System.out.println("Appointment: " + a.getTreatment().getName() + " at " + a.getDateTime() + ", Status: " + a.getStatus()));
        System.out.println("Enter Treatment Name to mark as attended:");
        String treatmentName = scanner.nextLine();
        Optional<Appointment> appointment = patientAppointments.stream()
            .filter(a -> a.getTreatment().getName().equals(treatmentName))
            .findFirst();
        if (!appointment.isPresent()) {
            System.out.println("Appointment not found.");
            return;
        }
        appointment.get().setStatus("Attended");
        System.out.println("Appointment for " + treatmentName + " marked as attended.");
    }

    private static void generatePhysicianReport() {
        LocalDate fourWeeksAgo = LocalDate.now().minusWeeks(4); // Date four weeks ago from today
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
        System.out.println("\nPhysician Report for the last 4 weeks:");
        printReportTableHeader(); // Print the header for the report table
    
        for (Physician physician : physicians) {
            System.out.println("Physician: " + physician.getFullName());
            appointments.stream()
                .filter(a -> a.getTreatment().getResponsiblePhysician().equals(physician))
                .filter(a -> !a.getDateTime().toLocalDate().isBefore(fourWeeksAgo)) // Filter by date
                .forEach(a -> {
                    String date = a.getDateTime().toLocalDate().format(dateFormatter);
                    String time = a.getDateTime().toLocalTime().format(timeFormatter);
                    printReportTableRow(a.getTreatment().getName(), a.getPatient().getFullName(), date, time, a.getStatus());
                });
        }
    }
    
    private static void printReportTableHeader() {
        System.out.printf("%-50s %-20s %-15s %-10s %-15s%n", "Treatment", "Patient", "Date", "Time", "Status");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
    private static void printReportTableRow(String treatment, String patient, String date, String time, String status) {
        System.out.printf("%-50s %-20s %-15s %-10s %-15s%n", treatment, patient, date, time, status);
    }
    

    private static void generatePatientReport() {
        LocalDate fourWeeksAgo = LocalDate.now().minusWeeks(4); // Date four weeks ago from today
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
        System.out.println("\nPatient Report for the last 4 weeks:");
        printPatientReportTableHeader(); // Print the header for the report table
    
        for (Patient patient : patients) {
            System.out.println("\nPatient: " + patient.getFullName());
            appointments.stream()
                .filter(a -> a.getPatient().equals(patient))
                .filter(a -> !a.getDateTime().toLocalDate().isBefore(fourWeeksAgo)) // Filter by date
                .forEach(a -> {
                    String date = a.getDateTime().toLocalDate().format(dateFormatter);
                    String time = a.getDateTime().toLocalTime().format(timeFormatter);
                    printPatientReportTableRow(a.getTreatment().getName(), a.getTreatment().getResponsiblePhysician().getFullName(), date, time, a.getStatus());
                });
        }
    }
    
    private static void printPatientReportTableHeader() {
        System.out.printf("%-50s %-25s %-15s %-10s %-15s%n", "Treatment", "Physician", "Date", "Time", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }
    
    private static void printPatientReportTableRow(String treatment, String physician, String date, String time, String status) {
        System.out.printf("%-50s %-25s %-15s %-10s %-15s%n", treatment, physician, date, time, status);
    }
    
    private static void printTableRow(String... columns) {
        String rowFormat = "%-20s %-30s %-15s %-25s %-15s %-15s%n";
        System.out.printf(rowFormat, (Object[]) columns);
    }

    private static void printTableHeader(String... headers) {
        printTableRow(headers);
        for (int i = 0; i < headers.length; i++) {
            for (int j = 0; j < headers[i].length(); j++) {
                System.out.print("-");
            }
            System.out.print(" ");
        }
        System.out.println();  // Move to the next line after header
    }
}