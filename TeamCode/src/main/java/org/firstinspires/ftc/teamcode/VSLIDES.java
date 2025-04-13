package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class VSLIDES {
    private final WORLDSHARDWARE hardware;
    private final WORLDSCONSTANTS constant = new WORLDSCONSTANTS();

    public VSLIDES(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }

    public void vslide_up() {
        hardware.vertSlideRight.setPower(constant.SLIDE_UP_POWER);
        hardware.vertSlideLeft.setPower(constant.SLIDE_UP_POWER);
    }

    public void vslide_down() {
        hardware.vertSlideRight.setPower(constant.SLIDE_DOWN_POWER);
        hardware.vertSlideLeft.setPower(constant.SLIDE_DOWN_POWER);
    }

    public void vzero(){
        hardware.vertSlideRight.setPower(0);
        hardware.vertSlideLeft.setPower(0);
    }

    public void outtake_s3(){
        hardware.vertSlideLeft.setTargetPosition(900);
        hardware.vertSlideRight.setTargetPosition(900);

        hardware.vertSlideLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        hardware.vertSlideRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        hardware.vertSlideLeft.setPower(1);
        hardware.vertSlideRight.setPower(1);

    }


}
