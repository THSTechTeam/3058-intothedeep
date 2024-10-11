package org.firstinspires.ftc.teamcode.working_code.Autonomus;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "RedParkingAA")
public class ParkingAA extends LinearOpMode {

    //call motors here
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;

    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("MotorFR");
        MotorFL = hardwareMap.dcMotor.get("MotorFL");
        MotorBR = hardwareMap.dcMotor.get("MotorBR");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");


        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        drive(0.25, 200);
        strafe(0.5, 1900);
        drive(-0.25, 50);
    }

    public void drive(double power, long time) {
        // + = forward
        MotorFR.setPower(power);
        MotorFL.setPower(power);
        MotorBR.setPower(power);
        MotorBL.setPower(power);
        sleep(time);
        stop_motors();
    }

    public void turn(double power, long time) {
        // + = left
        MotorFR.setPower(-power);
        MotorFL.setPower(power);
        MotorBR.setPower(-power);
        MotorBL.setPower(power);
        sleep(time);
        stop_motors();

    }

    public void strafe(double power, long time) {
        // + = left
        MotorFR.setPower(-power);
        MotorFL.setPower(power);
        MotorBR.setPower(power);
        MotorBL.setPower(-power);
        sleep(time);
        stop_motors();
    }

    public void stop_motors() {
        MotorFR.setPower(0);
        MotorFL.setPower(0);
        MotorBR.setPower(0);
        MotorBL.setPower(0);

    }

}