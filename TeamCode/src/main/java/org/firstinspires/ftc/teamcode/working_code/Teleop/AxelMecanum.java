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
    private Servo GrabberPivot;
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
        GrabberPivot = hardwareMap.get(Servo.class, "GrabberPivot");
        GrabberPickUp = hardwareMap.get(CRServo.class, "GrabberPickUp");

        MotorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        /*
        HorizontalSlide.setTargetPosition(111);
        VerticalSlide.setTargetPosition(111);

        HorizontalSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        VerticalSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        */
        HorizontalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        VerticalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        TopGrabber.setPosition(0.35);
        float PivotPosition = 0;

        while (opModeIsActive()) {
            /*
            VerticalSlide.setTargetPosition(111);
            HorizontalSlide.setTargetPosition(111);

            VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            HorizontalSlide.setPower(0.3);
            VerticalSlide.setPower(0.3);

            if (gamepad2.a) {
                HorizontalSlide.setTargetPosition(1000);

                HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                HorizontalSlide.setPower(0.3);

            } else if (gamepad2.b) {
                HorizontalSlide.setTargetPosition(2000);

                HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                HorizontalSlide.setPower(0.3);

            } else {
                HorizontalSlide.setTargetPosition(111);

                HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                HorizontalSlide.setPower(0.3);

            }
            if (gamepad2.x) {
                VerticalSlide.setTargetPosition(1000);

                VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                VerticalSlide.setPower(0.3);

            } else if (gamepad2.y) {
                VerticalSlide.setTargetPosition(2000);

                VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                VerticalSlide.setPower(0.3);

            } else {
                VerticalSlide.setTargetPosition(111);

                VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                VerticalSlide.setPower(0.3);
            */
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double max = Math.max(Math.abs(strafe) + Math.abs(drive) + Math.abs(turn), 1);

            //GrabberPivot.setPower(gamepad1.right_trigger-gamepad1.left_trigger);



            if (gamepad2.b)
            {
                 PivotPosition += 0.1;
            }
            else if (gamepad2.x) {
                 PivotPosition -= 0.1;
            }
            GrabberPivot.setPosition(PivotPosition);

            //GrabberPivot.setPower(gamepad2.left_stick_y - gamepad2.left_stick_y);
            telemetry.addData("Pivot.Port: ", GrabberPivot.getPortNumber());
            telemetry.addData("GrabberPivot.Position: ", GrabberPivot.getPosition());
            telemetry.update();

            if (gamepad2.right_bumper) {
                GrabberPickUp.setPower(0.9);
            } else if (gamepad2.left_bumper) {
                GrabberPickUp.setPower(-0.9);
            } else {
                GrabberPickUp.setPower(0);
            } if (gamepad1.b) {
                TopGrabber.setPosition(0.8);
            } else if (gamepad1.x) {
                TopGrabber.setPosition(0.35);
            }
            /*
            if (gamepad1.right_bumper)
            {
                VerticalSlide.setPower(0.5);
            }
            else if (gamepad1.left_bumper)
            {
                VerticalSlide.setPower(-0.75);
            }
            else
            {
                VerticalSlide.setPower(0);
            }
            */
            VerticalSlide.setPower(gamepad1.right_trigger - gamepad1.left_trigger);
            HorizontalSlide.setPower(gamepad2.left_trigger /2 - gamepad2.right_trigger / 2);
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