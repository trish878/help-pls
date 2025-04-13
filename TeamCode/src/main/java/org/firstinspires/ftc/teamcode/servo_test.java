package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;



@Config
@TeleOp(name="Servo Test")
public class servo_test extends OpMode {

    // Declare the servos
    Servo servo1, servo2, servo3, servo4;

    // Preset positions
    public static double servo1_pos;
    public static double servo2_pos ;
    public static double servo3_pos;
    public static double servo4_pos;







    public void init() {
        // Initialize servos from hardware map
        servo1 = hardwareMap.get(Servo.class, "rotateLeft");
        servo2 = hardwareMap.get(Servo.class, "rotateRight");
        servo3 = hardwareMap.get(Servo.class, "rotateClaw");
        servo4 = hardwareMap.get(Servo.class, "OuttakeClaw");

        servo2.setDirection(Servo.Direction.REVERSE);
        servo4.setDirection(Servo.Direction.REVERSE);




    }


    public void loop() {
        // Toggle servo1 with A button
        servo1.setPosition(servo1_pos);
        servo2.setPosition(servo2_pos);
        servo3.setPosition(servo3_pos);
        servo4.setPosition(servo4_pos);


        /*if (((hardware.vertSlideLeft.getCurrentPosition()-motor_pos)>10) && (motor_pos>hardware.vertSlideLeft.getCurrentPosition())){
            hardware.vertSlideLeft.setPower(constants.SLIDE_UP_POWER);
            hardware.vertSlideRight.setPower(constants.SLIDE_UP_POWER);

        }

        else if (((hardware.vertSlideLeft.getCurrentPosition()-motor_pos)>10) && (motor_pos<hardware.vertSlideLeft.getCurrentPosition())){
            hardware.vertSlideLeft.setPower(constants.SLIDE_DOWN_POWER);
            hardware.vertSlideRight.setPower(constants.SLIDE_DOWN_POWER);

        }
        else{
            hardware.vertSlideLeft.setPower(0);
            hardware.vertSlideRight.setPower(0);

        }*/

    }
}
