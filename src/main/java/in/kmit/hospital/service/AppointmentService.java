package in.kmit.hospital.service;

import in.kmit.hospital.model.Appointment;
import in.kmit.hospital.model.Doctor;
import in.kmit.hospital.model.Patient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private int nextAppointmentId = 1;

    public void addPatient(Patient patient) { patients.add(patient); }
    public void addDoctor(Doctor doctor) { doctors.add(doctor); }

    public Patient findPatient(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Doctor findDoctor(int id) {
        return doctors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public Appointment bookAppointment(int patientId, int doctorId, LocalDateTime dateTime) {
        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);
        if (patient == null || doctor == null) {
            throw new IllegalArgumentException("Invalid patient or doctor ID");
        }
        Appointment appointment = new Appointment(nextAppointmentId++, patient, doctor, dateTime);
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> getAppointments() {
        return List.copyOf(appointments);
    }
}
