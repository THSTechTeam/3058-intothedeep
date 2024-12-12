package org.firstinspires.ftc.teamcode.working_code.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "MecanumTeleop")
public class MecanumTeleop extends LinearOpMode {

    //call motors here
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;
    private DcMotorEx VerticalSlide;
    private DcMotorEx HorizontalSlide;
    private Servo TopGrabber;

    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("MotorFR");
        MotorFL = hardwareMap.dcMotor.get("MotorFL");
        MotorBR = hardwareMap.dcMotor.get("MotorBR");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");
        HorizontalSlide = hardwareMap.get(DcMotorEx.class, "HorizontalSlide");
        VerticalSlide = hardwareMap.get(DcMotorEx.class, "VerticalSlide");
        TopGrabber = hardwareMap.get(Servo.class, "TopGrabber");



        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        HorizontalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT); //TODO set back to BRAKE
        VerticalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        HorizontalSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        //VerticalSlide.setDirection(DcMotorSimple.Direction.REVERSE);




        //HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {

            HorizontalSlide.setTargetPositionTolerance(15);
            VerticalSlide.setTargetPositionTolerance(15);

            HorizontalSlide.setPower(0.3);
            VerticalSlide.setPower(0.3);

            //HorizontalSlide.setTargetPosition(96);
            //VerticalSlide.setTargetPosition(8);

            if (gamepad2.a)
            {
                VerticalSlide.setPower(-0.3);
                VerticalSlide.setTargetPosition(1780);
                VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad2.b)
            {
                HorizontalSlide.setTargetPosition(96);
                //HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad2.x)
            {
                //Fully extended is 1750
                HorizontalSlide.setTargetPosition(800);
                //HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad2.y)
            {   //Fully extended is 3898
                VerticalSlide.setTargetPosition(5500);
                //VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (VerticalSlide.getCurrentPosition() < 1700) {
                VerticalSlide.setTargetPosition((int) (VerticalSlide.getCurrentPosition() - gamepad2.left_stick_y * 2000));
            }

            if (HorizontalSlide.getCurrentPosition() < 1700) {
                HorizontalSlide.setTargetPosition((int) (HorizontalSlide.getCurrentPosition() - gamepad2.right_stick_y * 2000));
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
                /*if (gamepad2.a){
                    TopGrabber.setPosition(30);
                }*/
            PowerFR = gamepad1.a ? 1.0 : 0.0;  // A
            PowerFL = gamepad1.y ? 1.0 : 0.0;  // Y
            PowerBR = gamepad1.b ? 1.0 : 0.0;  // B
            PowerBL = gamepad1.x ? 1.0 : 0.0;  // X

            MotorFR.setPower(PowerFR);
            MotorFL.setPower(PowerFL);
            MotorBR.setPower(PowerBR);
            MotorBL.setPower(PowerBL);


            VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            telemetry.addData("Current VerticalSlide.Power: ", VerticalSlide.getPower());
            telemetry.addData("Current VerticalSlide.targetPosition: ", VerticalSlide.getTargetPosition());
            telemetry.addData("Current VerticalSlide.Pos: ", VerticalSlide.getCurrentPosition());
            telemetry.addData("Current HorizontalSlide.Power: ", HorizontalSlide.getPower());
            telemetry.addData("Current HorizontalSlide.TargetPos: ", HorizontalSlide.getTargetPosition());
            telemetry.addData("Current HorizontalSlide.Pos: ", HorizontalSlide.getCurrentPosition());
            telemetry.addData("Current TopGrabber.Pos: ", TopGrabber.getPosition());
            telemetry.update();

        }}}

