package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class FSM extends LinearOpMode {
    WORLDSHARDWARE hardware;
    WORLDSCONSTANTS constants;

    DRIVE drive;
    HSLIDES hslide;
    VSLIDES vslide;
    INTAKECLAW intake;
    OUTTAKECLAW outtake;

    // Control toggles
    boolean intakeIO = false;
    int intakeClawState = 0;
    int outtakeToggle = 0;

    boolean intakeRight = true;

    Gamepad currentGamepad1, currentGamepad2;
    Gamepad previousGamepad1 = new Gamepad();
    Gamepad previousGamepad2 = new Gamepad();

    public enum LiftState {
        LIFT_START,
        LIFT_EXTEND,
        LIFT_DUMP,
        LIFT_RETRACT
    }
    LiftState liftState = LiftState.LIFT_START;

    public enum VerticalSlideState {
        IDLE,
        GOING_UP,
        GOING_DOWN,

    }
    VerticalSlideState vSlideState = VerticalSlideState.IDLE;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize
        hardware = new WORLDSHARDWARE(hardwareMap);
        constants = new WORLDSCONSTANTS();
        drive = new DRIVE(hardware);
        hslide = new HSLIDES(hardware);
        vslide = new VSLIDES(hardware);
        intake = new INTAKECLAW(hardware);
        outtake = new OUTTAKECLAW(hardware);

        currentGamepad1 = gamepad1;
        currentGamepad2 = gamepad2;

        waitForStart();

        while (opModeIsActive()) {
            // Store previous state
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);



            // Drivetrain and HSlide
            double x = -currentGamepad1.left_stick_x;
            double y = currentGamepad1.left_stick_y;
            double r = -0.5 * currentGamepad1.right_stick_x;
            drive.drive(x, y, r);
            double g2lsy = currentGamepad2.left_stick_y;
            double g2rsx = currentGamepad2.right_stick_x;
            hslide.hslide(g2lsy);


            int slide_position = hardware.vertSlideLeft.getCurrentPosition();

            if ((currentGamepad1.left_trigger > 0.25)) {
                vSlideState = vSlideState.GOING_UP;
            } else if (currentGamepad1.right_trigger > 0.25) {
                vSlideState = vSlideState.GOING_DOWN;
            } else {
                vSlideState = vSlideState.IDLE;
            }

            switch (vSlideState) {
                case GOING_UP:
                    vslide.vslide_up();
                    break;
                case GOING_DOWN:
                    vslide.vslide_down();
                    break;
                case IDLE:
                    vslide.vzero();
                    break;
            }

            if ((currentGamepad2.right_trigger > 0.25) && !(previousGamepad2.right_trigger > 0.25)) {
                intakeIO = !intakeIO;
            }

            if (intakeIO) intake.in_close();
            else intake.in_open();

            if (currentGamepad2.dpad_up && !previousGamepad2.dpad_up) {
                intakeClawState= intakeClawState+1;

                intakeClawState = (intakeClawState) % 3;
            }

            switch (intakeClawState) {
                case 0:
                    intake.pos1();
                    break;
                case 1:
                    intake.pos2(g2rsx);
                    break;
                case 2:
                    intake.pos3(g2rsx);
                    break;
                case 3:
                    intakeClawState = 0;
                    break;

            }

            if (currentGamepad2.dpad_right && !previousGamepad2.dpad_right) {
                intakeRight = !intakeRight;


            }

            if (intakeRight) intake.pos1();
            else intake.pos4(g2rsx);



            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {
                outtakeToggle = outtakeToggle+1;
                outtakeToggle = (outtakeToggle) % 4;
            }

            switch (outtakeToggle) {
                case 0:
                    outtake.intake();
                    break;

                case 1:
                    slide_position = hardware.vertSlideLeft.getCurrentPosition();
                    switch (vSlideState) {
                        case GOING_UP:
                            vslide.outtake_s3_down();
                        case GOING_DOWN:
                            vslide.outtake_s3_up();  // Move to correct height for scoring
                            break;
                        default:
                            vslide.vzero_test();
                            break;
                    }

                    if (slide_position < 900){
                        while(slide_position < 900){
                            slide_position = hardware.vertSlideLeft.getCurrentPosition();
                            vSlideState = VerticalSlideState.GOING_UP;

                        }
                    }else{
                        while(slide_position > 900){
                            slide_position = hardware.vertSlideLeft.getCurrentPosition();
                            vSlideState = VerticalSlideState.GOING_DOWN;

                        }

                    }
                    break;

                case 2:
                    outtake.outtake();
                    break;

                case 3:
                    outtake.transfer();
                    break;
            }

            telemetry.addData("encoders", hardware.vertSlideLeft.getCurrentPosition());
            telemetry.update();
            currentGamepad1 = gamepad1;
            currentGamepad2 = gamepad2;
        }
    }
}
