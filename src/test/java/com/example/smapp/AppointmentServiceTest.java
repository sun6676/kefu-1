package com.example.smapp;

import com.example.smapp.entity.Appointment;
import com.example.smapp.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;
    @Test
    void testGetOne(){
        Appointment appointment = new Appointment();
        appointment.setUsername("张三");
        appointment.setIdCard("12345");
        appointment.setDepartment("呼吸科");
        appointment.setDate("2025-04-14");
        appointment.setTime("上午");
        //appointment.setDoctorName("张医生");
        Appointment appointmentDB = appointmentService.getOne(appointment);
        System.out.println(appointmentDB);
    }


    @Test
    void testSave(){
        Appointment appointment = new Appointment();
        appointment.setUsername("张三");
        appointment.setIdCard("12345");
        appointment.setDepartment("呼吸科");
        appointment.setDate("2025-04-14");
        appointment.setTime("上午");
        //appointment.setDoctorName("张医生");
        appointmentService.save(appointment);
    }

    @Test
    void testRemoveById(){
        appointmentService.removeById(1L);
    }
}
