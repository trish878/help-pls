

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class FSM extends LinearOpMode{
    WORLDSHARDWARE hardware = new WORLDSHARDWARE(hardwareMap);
    WORLDSCONSTANTS constant = new WORLDSCONSTANTS();

    DRIVE drive = new DRIVE(hardware);
    HSLIDES hslide = new HSLIDES(hardware);
    VSLIDES vslide = new VSLIDES(hardware);
    INTAKECLAW intake = new INTAKECLAW(hardware);
    OUTTAKECLAW outtake = new OUTTAKECLAW(hardware);
    public FSM(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }



    public enum LiftState{
        LIFT_START,
        LIFT_OUT,

        LIFT_IN,

        SAMPLE_EXTEND,

        SAMPLE_RETRACT

    }
    LiftState liftState = LiftState.LIFT_START;



    @Override
    public void runOpMode() throws InterruptedException {
        boolean SAMPLE = false;
        boolean SPECIMEN =false;
        waitForStart();
        while (opModeIsActive()) {
            switch(liftState){
                case LIFT_START:
                    hardware.outtakeClaw.setPosition(0);


                case LIFT_IN:
                case LIFT_OUT:

                case SAMPLE_EXTEND:
                case SAMPLE_RETRACT:

            }
        }
    }
}
