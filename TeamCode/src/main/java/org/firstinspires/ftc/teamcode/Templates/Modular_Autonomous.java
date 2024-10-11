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

    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("motorFrontLeft");
        MotorFL = hardwareMap.dcMotor.get("motorFrontRight");
        MotorBR = hardwareMap.dcMotor.get("motorBackLeft");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");



        MotorFL.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorBL.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        while(opModeIsActive()) {
            drive(1, 2000);
            strafe(1, 2000);
            turn(1, 2000);
            stop_motors();
        }
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