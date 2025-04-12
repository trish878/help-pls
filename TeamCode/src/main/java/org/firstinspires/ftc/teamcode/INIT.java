package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class INIT {
    private WORLDSHARDWARE hardware;
    private WORLDSCONSTANTS constants;

    public INIT(HardwareMap hardwareMap) {

        hardware = new WORLDSHARDWARE(hardwareMap);
        constants = new WORLDSCONSTANTS();

        //TODO: Encoders

        hardware.vertSlideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //TODO: SetPositions

        //Intake
        hardware.intakeHor.setPosition(constants.INTAKE_HOR_SHIFT_POS_SUB);
        hardware.intakeVert.setPosition(constants.INTAKE_VERT_SHIFT_POS_TRANSFER);
        hardware.intakeWrist.setPosition(0);
        hardware.intakeClaw.setPosition(constants.INTAKE_CLAW_OPEN_POS);

        //Outtake
        hardware.outtakeArmLeft.setPosition(constants.ROTATE_ARM_INTAKE_POS);
        hardware.outtakeArmRight.setPosition(constants.ROTATE_ARM_INTAKE_POS + constants.ROTATE_ARM_SHIFT);
        hardware.outtakeArmWrist.setPosition(constants.ROTATE_CLAW_INTAKE_POS);
        hardware.outtakeClaw.setPosition(constants.OUTTAKE_CLAW_OPEN_POS);


    }
}
