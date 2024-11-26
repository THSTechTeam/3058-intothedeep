package org.firstinspires.ftc.teamcode.Templates;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@Autonomous(name = "Mod Auto", group = "Autonomous")
public class Modular_Autonomous extends LinearOpMode {

    //call motors here
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;
    private DcMotor VerticalSlide = null;
    private DcMotor HorizontalSlide = null;

    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("MotorFR");
        MotorFL = hardwareMap.dcMotor.get("MotorFL");
        MotorBR = hardwareMap.dcMotor.get("MotorBR");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");
        HorizontalSlide = hardwareMap.dcMotor.get("HorizontalSlide");
        VerticalSlide = hardwareMap.dcMotor.get("VerticalSlide");



        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        HorizontalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        VerticalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        HorizontalSlide.setPower(0.1);
        VerticalSlide.setPower(0.1);

        //HorizontalSlide = hardwareMap.dcMotor.get("")
        waitForStart();

            drive(1, 2000);
            strafe(1, 2000);
            turn(1, 2000);
            stop_motors();

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
    }

    public void DiagRight(double power, long time) {
        // + = Forward Right, - = Backward Left
        MotorFL.setPower(power);
        MotorBR.setPower(power);

    }
}