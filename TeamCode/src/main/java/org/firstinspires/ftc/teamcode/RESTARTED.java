package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class RESTARTED extends LinearOpMode {
    //private Gamepad currentGamepad1;
    //private Gamepad currentGamepad2;
    boolean outtake_io = false;
    int intake_claw = 0;
    boolean intake_io = false;
    int left_toggle = 0;

    public enum LiftState {
        LIFT_START,
        LIFT_EXTEND,
        LIFT_DUMP,
        LIFT_RETRACT
    }

    ;
    //CCLASS FOR CONTROLLING VERTICAL SLIDSE WITH SET POSITONS AND SET POIWER AND JS CALL VERTICAL SLIDE CLASS W POSITIONS
    //

    @Override
    public void runOpMode() throws InterruptedException {

        WORLDSHARDWARE hardware = new WORLDSHARDWARE(hardwareMap);
        WORLDSCONSTANTS constants = new WORLDSCONSTANTS();
        //LIMELIGHT limelight = new LIMELIGHT(hardwareMap);


        DRIVE drive = new DRIVE(hardware);
        HSLIDES hslide = new HSLIDES(hardware);
        VSLIDES vslide = new VSLIDES(hardware);
        INTAKECLAW intake = new INTAKECLAW(hardware);
        OUTTAKECLAW outtake = new OUTTAKECLAW(hardware);

        Gamepad currentGamepad1 = gamepad1;
        Gamepad currentGamepad2 = gamepad2;

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();


        //rip
        waitForStart();

        while (opModeIsActive()) {
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);


            double x = -currentGamepad1.left_stick_x;
            double y = currentGamepad1.left_stick_y;
            double r = -0.5 * currentGamepad1.right_stick_x;

            double g2lsy = currentGamepad2.left_stick_y;
            double g2rsx = currentGamepad2.right_stick_x;

            drive.drive(x, y, r);
            hslide.hslide(g2lsy);
            if (currentGamepad1.left_trigger > 0.25) {
                vslide.vslide_up();

            } else if (currentGamepad1.right_trigger > 0.25) {
                vslide.vslide_down();

            }
            // TODO: This is breaking  vslide.outtake_s3() below
            // Each time you try to run vslide.outtake_s3(), this code is run a few ms later
            // which stops the motors.
            // I made a change inside the vslide.vzero() that should fix this.
            else if (!(currentGamepad1.right_trigger > 0.25) && !(currentGamepad1.left_trigger > 0.25)) {
                vslide.vzero();
            }


            if ((currentGamepad2.right_trigger > 0.25) && !(previousGamepad2.right_trigger > 0.25)) {
                intake_io = !intake_io;

            }

            if (intake_io) {
                intake.in_close();
            } else {
                intake.in_open();
            }

            if (currentGamepad2.dpad_up && !previousGamepad2.dpad_up) {
                intake_claw += 1;
            }
            if (intake_claw == 0) {
                intake.pos1();
            }
            else if (intake_claw == 1) {
                intake.pos2(g2rsx);
            }
            else if (intake_claw == 2) {
                intake.pos3(g2rsx);
            }
            else if (intake_claw == 3) {
                intake_claw = 0;
            }

            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {
                left_toggle += 1;
            }
            if (left_toggle == 0) {
                outtake.intake();
            }

            else if (left_toggle == 1) {
                if (hardware.vertSlideLeft.getCurrentPosition()!=900){
                    //vslide.outtake_s3();
                }
                else{
                    vslide.vzero_test();
                }

            }
            else if (left_toggle == 2) {
                outtake.outtake();

            }
            else if (left_toggle == 3) {
                outtake.transfer();
            }
            else if (left_toggle == 4) {
                left_toggle = 0;
            }


            currentGamepad1 = gamepad1;
            currentGamepad2 = gamepad2;
            telemetry.addData("vals", hardware.vertSlideLeft.getCurrentPosition());
            telemetry.update();
        }

    }//ENCODER FOR
}



