package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OUTTAKECLAW {
    private final WORLDSHARDWARE hardware;
    private final WORLDSCONSTANTS constant = new WORLDSCONSTANTS();

    public OUTTAKECLAW(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }

    public void start() {
        hardware.outtakeArmLeft.setPosition(constant.ROTATE_ARM_INTAKE_POS + constant.ROTATE_ARM_SHIFT);
        hardware.outtakeArmRight.setPosition(constant.ROTATE_ARM_INTAKE_POS);
        hardware.outtakeArmWrist.setPosition(constant.ROTATE_CLAW_INTAKE_POS);
    }

    public void transfer() {
        hardware.outtakeArmLeft.setPosition(constant.ROTATE_ARM_OUTTAKE_POS + constant.ROTATE_ARM_SHIFT);
        hardware.outtakeArmRight.setPosition(constant.ROTATE_ARM_OUTTAKE_POS);
        hardware.outtakeArmWrist.setPosition(constant.ROTATE_CLAW_OUTTAKE_POS);
    }
    public void out_close(){
        hardware.outtakeClaw.setPosition(constant.OUTTAKE_CLAW_CLOSE_POS);
    }

    public void out_open(){
        hardware.outtakeClaw.setPosition(constant.OUTTAKE_CLAW_OPEN_POS);
    }
}
