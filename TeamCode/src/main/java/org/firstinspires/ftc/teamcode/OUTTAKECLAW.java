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

    public void intake() {
        hardware.outtakeArmLeft.setPosition(0.25);
        hardware.outtakeArmRight.setPosition(0.25);
        hardware.outtakeArmWrist.setPosition(0.05);
    }

    public void outtake() {
        hardware.outtakeArmLeft.setPosition(0.85);
        hardware.outtakeArmRight.setPosition(0.85);
        hardware.outtakeArmWrist.setPosition(0.6);
    }

    public void transfer(){
        hardware.outtakeArmLeft.setPosition(1);
        hardware.outtakeArmRight.setPosition(1);
        hardware.outtakeArmWrist.setPosition(0.6);


    }
    public void out_close(){
        hardware.outtakeClaw.setPosition(constant.OUTTAKE_CLAW_CLOSE_POS);
    }

    public void out_open(){
        hardware.outtakeClaw.setPosition(constant.OUTTAKE_CLAW_OPEN_POS);
    }
}
