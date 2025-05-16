package com.example.smapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smapp.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}
