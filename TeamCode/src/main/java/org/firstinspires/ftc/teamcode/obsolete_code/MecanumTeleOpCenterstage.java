package org.firstinspires.ftc.teamcode.obsolete_code;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@TeleOp(name="3058 Mecanum TeleOp", group="TeleOp")
public class MecanumTeleOpCenterstage extends LinearOpMode {

    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;
    //private DcMotor armL;
    //private DcMotor armR;
    //private DcMotor intake;
    //private DcMotor intake2;
    //private Servo handL; //Slot 0
    //private Servo handR; //slot 3
    //private Servo pitchL; //slot 1 RC
    //private Servo pitchR; // slot 0 RC

    @Override
    public void runOpMode() throws InterruptedException {

        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        //armL = hardwareMap.dcMotor.get("armL");
        //armR = hardwareMap.dcMotor.get("armR");
        //intake= hardwareMap.dcMotor.get("intake");
        //intake2 = hardwareMap.dcMotor.get("intake2");
        //handL = hardwareMap.servo.get("handL");
        //handR = hardwareMap.servo.get("handR");
        //pitchL = hardwareMap.servo.get("pitchL");
        //pitchR = hardwareMap.servo.get("pitchR");

        double FL;
        double FR;
        double BL;
        double BR;
        boolean ReverseDrive = false;
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        //intake2.setDirection(DcMotorSimple.Direction.REVERSE);
        //armL.setDirection(DcMotorSimple.Direction.REVERSE);
        //armL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //armR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
               while (opModeIsActive()) {
                   if (gamepad1.x) {
                       ReverseDrive = true;
                   } if (gamepad1.a) {
                       ReverseDrive = false;
                   }
                   double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double twist = -gamepad1.right_stick_x;

            double max = Math.max(Math.abs(strafe) + Math.abs(drive) + Math.abs(twist), 1);
            //Variables for wheel power
            if (ReverseDrive) {
                drive = -drive;
                //strafe = -strafe;
            }
            FL = ((drive + strafe + twist) / max);
            BL = ((drive - strafe + twist) / max);
            FR = ((drive - strafe - twist) / max);
            BR = ((drive + strafe - twist) / max);

            motorFrontLeft.setPower(FL);
            motorBackLeft.setPower(BL);
            motorFrontRight.setPower(FR);
            motorBackRight.setPower(BR);

            //armMove((gamepad2.right_trigger - gamepad2.left_trigger) + 0.05);

            //intake(gamepad1.right_trigger - gamepad1.left_trigger);
            //intake2(gamepad1.right_trigger - gamepad1.left_trigger);

            //if (gamepad2.left_bumper) { // Intake State
                //pitchR.setPosition(0.25);
                //pitchL.setPosition(0);
            }
            //if (gamepad2.dpad_up){
                //pitchR.setPosition(0.51);
            }
            //else if (gamepad2.right_bumper) { // Deposit State
                //pitchR.setPosition(0.95);
                // pitchL.setPosition(-0.8);
            }


        //}
            //idle();
        //}
    //private void intake2(double power) {
        //intake2.setPower(power);
    //}
    //private void intake(double power) {
        //intake.setPower(power);
    //}
    //public void armMove(double power){
        //armL.setPower(power);
        //armR.setPower(power);
    //}

//}

