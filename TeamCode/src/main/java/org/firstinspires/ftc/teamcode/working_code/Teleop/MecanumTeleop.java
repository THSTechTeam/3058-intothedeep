package org.firstinspires.ftc.teamcode.working_code.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MecanumTeleop")
public class MecanumTeleop extends LinearOpMode {

    //call motors here
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;
    private DcMotor VerticalSlide;
    private DcMotor HorizontalSlide;

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

        waitForStart();
        while (opModeIsActive()) {

            if (gamepad2.a)
            {
                VerticalSlide.setTargetPosition(0);
            }
            if (gamepad2.x)
            {
                HorizontalSlide.setTargetPosition(0);
            }
            if (gamepad2.y)
            {
                VerticalSlide.setTargetPosition(100);
            }
            if (gamepad2.y)
            {
                VerticalSlide.setTargetPosition(100);
            }


            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double max = Math.max(Math.abs(strafe) + Math.abs(drive) + Math.abs(turn), 1);


            double PowerFL = ((drive + strafe + turn) / max);
            double PowerBL = ((drive - strafe + turn) / max);
            double PowerFR = ((drive - strafe - turn) / max);
            double PowerBR = ((drive + strafe - turn) / max);


            if (gamepad1.dpad_up) {
                MotorFR.setPower(0.5);
                MotorFL.setPower(0.5);
                MotorBR.setPower(0.5);
                MotorBL.setPower(0.5);
            }
            if (gamepad1.dpad_down) {
                MotorFR.setPower(-0.5);
                MotorFL.setPower(-0.5);
                MotorBR.setPower(-0.5);
                MotorBL.setPower(-0.5);
            }
            if (gamepad1.dpad_left) {
                MotorFR.setPower(0.5);
                MotorFL.setPower(-0.5);
                MotorBR.setPower(-0.5);
                MotorBL.setPower(0.5);
            }
            if (gamepad1.dpad_right) {
                MotorFR.setPower(-0.5);
                MotorFL.setPower(0.5);
                MotorBR.setPower(0.5);
                MotorBL.setPower(-0.5);
            }

            MotorFR.setPower(PowerFR);
            MotorFL.setPower(PowerFL);
            MotorBR.setPower(PowerBR);
            MotorBL.setPower(PowerBL);
        }}}

