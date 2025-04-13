package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TestMotor extends LinearOpMode {



    @Override
    public void runOpMode() throws InterruptedException {

        WORLDSHARDWARE hardware = new WORLDSHARDWARE(hardwareMap);
        WORLDSCONSTANTS constants = new WORLDSCONSTANTS();

        hardware.vertSlideLeft = hardwareMap.get(DcMotorEx.class, "vertSlideLeft");
        hardware.vertSlideLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        hardware.vertSlideRight = hardwareMap.get(DcMotorEx.class, "vertSlideRight");
        hardware.vertSlideRight.setDirection(DcMotorSimple.Direction.FORWARD);


        hardware.vertSlideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Only reset left
        hardware.vertSlideLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

    while (opModeIsActive()) {
            if (gamepad1.left_bumper) {
                hardware.vertSlideLeft.setPower(constants.SLIDE_UP_POWER);
                hardware.vertSlideRight.setPower(constants.SLIDE_UP_POWER);
            }
            if (gamepad1.right_bumper) {
                hardware.vertSlideLeft.setPower(constants.SLIDE_DOWN_POWER);
                hardware.vertSlideRight.setPower(constants.SLIDE_DOWN_POWER);
            }


            telemetry.addData("encodervals", hardware.vertSlideLeft.getCurrentPosition());
            telemetry.update();

    }

}
}



