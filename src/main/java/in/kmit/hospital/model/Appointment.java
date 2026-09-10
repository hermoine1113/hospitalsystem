package in.kmit.hospital.model;

import java.time.LocalDateTime;

public class Appointment {
    private final int id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime dateTime;

    public Appointment(int id, Patient patient, Doctor doctor, LocalDateTime dateTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getDateTime() { return dateTime; }

    @Override
    public String toString() {
        return "Appointment #" + id + ": " + patient.getName() +
               " with Dr. " + doctor.getName() + " at " + dateTime;
    }
}
