package com.example.smapp.tools;

import com.example.smapp.entity.Appointment;
import com.example.smapp.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentTools {
    @Autowired
    private AppointmentService appointmentService;

    @Tool(name="预约挂号",value="根据参数先查询是否可以预约")
    public String bookAppointment(Appointment appointment){
        Appointment appointmentDB = appointmentService.getOne(appointment);

        if(appointmentDB == null){
            appointment.setId(null);
            if(appointmentService.save(appointment)){
                return "预约成功，并返回预约详情";
            }else {
                return "预约失败";
            }
        }
        return "您在相同的科室已有预约";
    }
    @Tool(name="取消预约",value="根据参数先查询预约是否存在，存在则删除返回true，否则返回false")
    public String cancelAppointment(Appointment appointment){
        Appointment appointmentDB = appointmentService.getOne(appointment);

        if(appointmentDB != null){
            if(appointmentService.removeById(appointmentDB.getId())){
                return "取消预约成功";
            }else {
                return "取消预约失败";
            }
        }
        return "您没有预约记录";
    }

    @Tool(name = "queryDepartment",
            value = "根据科室名称，日期，时间和医生查询是否有号源，并返回给用户")
    public boolean queryDepartment(
            @P(value = "科室名称") String name,
            @P(value = "日期") String date,
            @P(value = "时间，可选值：上午、下午") String time,
            @P(value = "医生名称", required = false) String doctorName
    ) {
        System.out.println("查询是否有号源");
        System.out.println("科室名称：" + name);
        System.out.println("日期：" + date);
        System.out.println("时间：" + time);
        System.out.println("医生名称：" + doctorName);

        // TODO: 实现实际的号源查询逻辑
        return true;
    }
}
