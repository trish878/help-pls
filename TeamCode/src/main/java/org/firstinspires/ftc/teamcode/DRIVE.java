package org.firstinspires.ftc.teamcode;

public class DRIVE {
    WORLDSHARDWARE hardware;

    public DRIVE(WORLDSHARDWARE hw) {
        this.hardware = hw;
    }

    public void drive(double x, double y, double r) {
        double FLe = y + x + r;
        double FRi = y - x - r;
        double BLe = y - x + r;
        double BRi = y + x - r;

        hardware.FL.setPower(FLe);
        hardware.FR.setPower(FRi);
        hardware.BL.setPower(BLe);
        hardware.BR.setPower(BRi);
    }
}
