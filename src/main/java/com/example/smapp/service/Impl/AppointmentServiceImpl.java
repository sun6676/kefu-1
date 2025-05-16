package com.example.smapp.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smapp.entity.Appointment;
import com.example.smapp.mapper.AppointmentMapper;
import com.example.smapp.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    public Appointment getOne(Appointment appointment){
        LambdaQueryWrapper<Appointment> queryWrapper= new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getUsername,appointment.getUsername());
        queryWrapper.eq(Appointment::getIdCard,appointment.getIdCard());
        queryWrapper.eq(Appointment::getDepartment,appointment.getDepartment());
        queryWrapper.eq(Appointment::getTime,appointment.getTime());
        queryWrapper.eq(Appointment::getDate,appointment.getDate());
        Appointment appointmentDB = baseMapper.selectOne(queryWrapper);
        return appointmentDB;

    }
}
