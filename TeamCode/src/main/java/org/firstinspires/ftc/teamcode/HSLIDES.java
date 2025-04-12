package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HSLIDES {
    private final WORLDSHARDWARE hardware;
    private final WORLDSCONSTANTS constant = new WORLDSCONSTANTS();

    public HSLIDES(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }

    public void hslide(double g2lsy) {
        hardware.horSlide.setPower(constant.LINKAGE_COEF * g2lsy);
    }
}
