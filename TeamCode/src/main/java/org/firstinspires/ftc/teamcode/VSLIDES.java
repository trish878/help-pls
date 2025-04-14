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
        // TODO: Important!  If you run outtake_s3, your motors are in RUN_TO_POSITION mode
        // but this method wants them to be in "normal" mode.  So you need to run:

        // .setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER)
        // or
        // .setMode(DcMotorEx.RunMode.RUN_WITH_ENCODER)

        // The second one might be better because it tries to control the velocity of
        // the motors so will run both at the same speed.
        //
        // Same in vslide_down()

        hardware.vertSlideRight.setPower(constant.SLIDE_UP_POWER);
        hardware.vertSlideLeft.setPower(constant.SLIDE_UP_POWER);
    }

    public void vslide_down() {
        hardware.vertSlideRight.setPower(constant.SLIDE_DOWN_POWER);
        hardware.vertSlideLeft.setPower(constant.SLIDE_DOWN_POWER);
    }

    public void vzero(){
        // TODO: This should fix the issue where the power is being set to 0
        // even when you are trying to run outtake_s3()
        // I'm checking if it is in RUN_TO_POSITION mode before setting the
        // power to 0.  If it is in RUN_TO_POSITION mode, then the PID will
        // control the power.
        if(hardware.vertSlideLeft.getMode() != DcMotorEx.RunMode.RUN_TO_POSITION) {
            hardware.vertSlideRight.setPower(0);
            hardware.vertSlideLeft.setPower(0);
        }

    }
    public void vzero_test(){
        hardware.vertSlideRight.setPower(0);
        hardware.vertSlideLeft.setPower(0);

    }

    public void outtake_s3_up() {
            while (hardware.vertSlideLeft.getCurrentPosition() < 900) {
                hardware.vertSlideLeft.setPower(1);
                hardware.vertSlideRight.setPower(1);
            }

    }

    public void outtake_s3_down(){
        while (hardware.vertSlideLeft.getCurrentPosition() > 900) {
            hardware.vertSlideLeft.setPower(-1);
            hardware.vertSlideRight.setPower(-1);
        }

    }
        /*
        hardware.vertSlideLeft.setTargetPosition(900);
        hardware.vertSlideRight.setTargetPosition(900);

        hardware.vertSlideLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        hardware.vertSlideRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        hardware.vertSlideLeft.setPower(1);
        hardware.vertSlideRight.setPower(1);
        */


    }


