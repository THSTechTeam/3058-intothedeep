package org.firstinspires.ftc.teamcode.working_code.Autonomus;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@Autonomous(name = "subAutoPark", group = "Autonomous")
public class subAutoPark extends LinearOpMode {

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

        int Line1 = 2000;
        int Line2 = 1200;
        int Line3 = 800;


        strafe(-0.5, 1000);
        drive(-0.5, Line1);
        strafe(-0.5, 1350);
        turn(0.5,650);
        strafe(-0.5, 900);
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

    public void DiagLeft(double power, long time) {
        // + = Forward Left, - = Backward Right
        MotorFR.setPower(power);
        MotorBL.setPower(power);
        sleep(time);
        stop_motors();
    }

    public void DiagRight(double power, long time) {
        // + = Forward Right, - = Backward Left
        MotorFL.setPower(power);
        MotorBR.setPower(power);
        sleep(time);
        stop_motors();

    }
}