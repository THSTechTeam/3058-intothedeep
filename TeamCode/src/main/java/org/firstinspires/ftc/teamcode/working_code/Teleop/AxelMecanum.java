package org.firstinspires.ftc.teamcode.working_code.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "Axels")
public class  AxelMecanum extends LinearOpMode {

    //call motors here
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;
    private DcMotor VerticalSlide;
    private DcMotor HorizontalSlide;
    private Servo TopGrabber;
    private CRServo GrabberPivot;
    private CRServo GrabberPickUp;
    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("MotorFR");
        MotorFL = hardwareMap.dcMotor.get("MotorFL");
        MotorBR = hardwareMap.dcMotor.get("MotorBR");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");
        HorizontalSlide = hardwareMap.get(DcMotor.class, "HorizontalSlide");
        VerticalSlide = hardwareMap.get(DcMotor.class, "VerticalSlide");
        TopGrabber = hardwareMap.get(Servo.class, "TopGrabber");
        GrabberPivot = hardwareMap.get(CRServo.class, "GrabberPivot");
        GrabberPickUp = hardwareMap.get(CRServo.class, "GrabberPickUp");

        MotorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*
        HorizontalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        VerticalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        */
        waitForStart();
        while (opModeIsActive()) {

            /*
            HorizontalSlide.setPower(0.3);
            VerticalSlide.setPower(0.3);

            if (gamepad2.a) {
                HorizontalSlide.setTargetPosition(1000);
            } else if (gamepad2.b) {
                HorizontalSlide.setTargetPosition(2000);
            } else {
                HorizontalSlide.setTargetPosition(111);
            }
            if (gamepad2.x) {
                VerticalSlide.setTargetPosition(1000);
            } else if (gamepad2.y) {
                VerticalSlide.setTargetPosition(2000);
            } else {
                VerticalSlide.setTargetPosition(111);
            }
            */
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double max = Math.max(Math.abs(strafe) + Math.abs(drive) + Math.abs(turn), 1);

            double PowerFL = ((drive + strafe + turn) / max);
            double PowerBL = ((drive - strafe + turn) / max);
            double PowerFR = ((drive - strafe - turn) / max);
            double PowerBR = ((drive + strafe - turn) / max);

            MotorFR.setPower(PowerFR);
            MotorFL.setPower(PowerFL);
            MotorBR.setPower(PowerBR);
            MotorBL.setPower(PowerBL);
            /*
            VerticalSlide.setTargetPosition(111);
            HorizontalSlide.setTargetPosition(111);

            VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            */
        }}}