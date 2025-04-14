package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class INTAKECLAW {
    private final WORLDSHARDWARE hardware;
    private final WORLDSCONSTANTS constant = new WORLDSCONSTANTS();



    public INTAKECLAW(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }

    public void pos1() {
        hardware.intakeHor.setPosition(constant.INTAKE_HOR_SHIFT_POS_TRANSFER);
        hardware.intakeVert.setPosition(constant.INTAKE_VERT_SHIFT_POS_TRANSFER);
        hardware.intakeWrist.setPosition(constant.INTAKE_WRIST_TRANSFER);
    }

    public void pos2(double g2rsx) {
        hardware.intakeHor.setPosition(constant.INTAKE_HOR_SHIFT_POS_SUB - g2rsx / 4);
        hardware.intakeVert.setPosition(constant.INTAKE_VERT_SHIFT_POS_UP);
    }

    public void pos3(double g2rsx){
        hardware.intakeHor.setPosition(constant.INTAKE_HOR_SHIFT_POS_SUB - g2rsx / 4);
        hardware.intakeVert.setPosition(constant.INTAKE_VERT_SHIFT_POS_DOWN);

    }
    public void pos4(double g2rsx) {
        hardware.intakeHor.setPosition(constant.INTAKE_HOR_SHIFT_POS_HP - g2rsx / 4);
        hardware.intakeVert.setPosition(constant.INTAKE_VERT_SHIFT_POS_HP);

    }
        public void in_close(){
        hardware.intakeClaw.setPosition(constant.INTAKE_CLAW_CLOSE_POS);

    }
    public void in_open(){
        hardware.intakeClaw.setPosition(constant.INTAKE_CLAW_OPEN_POS);

    }
}
///CLAW ROTATTION SHOULD BE 0.06
//