package org.firstinspires.ftc.teamcode.working_code.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

// TODO Clean Up Code (Remove Unnecessary components && add lots of comments)
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
    private Servo GrabberPivot;
    private CRServo GrabberPickUp;




    @Override

    public void runOpMode() throws InterruptedException {

        MotorFR = hardwareMap.dcMotor.get("MotorFR");
        MotorFL = hardwareMap.dcMotor.get("MotorFL");
        MotorBR = hardwareMap.dcMotor.get("MotorBR");
        MotorBL = hardwareMap.dcMotor.get("MotorBL");
        HorizontalSlide = hardwareMap.get(DcMotorEx.class, "HorizontalSlide");
        VerticalSlide = hardwareMap.get(DcMotorEx.class, "VerticalSlide");
        TopGrabber = hardwareMap.get(Servo.class, "TopGrabber");
        GrabberPivot = hardwareMap.get(Servo.class, "GrabberPivot");
        GrabberPickUp = hardwareMap.get(CRServo.class, "GrabberPickUp");



        MotorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        HorizontalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        VerticalSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        HorizontalSlide.setDirection(DcMotorSimple.Direction.REVERSE);


        //VerticalSlide.setDirection(DcMotorSimple.Direction.REVERSE);




        //HorizontalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        int verticalStart = VerticalSlide.getCurrentPosition();
        int horizontalStart = HorizontalSlide.getCurrentPosition();
        int basket1= verticalStart + 1650;
        int basket2 = verticalStart + 3900;
        int horizontalMax = horizontalStart = 1600;
        double tipPos;
        double levelPos;
        double GrabberPivotDefault;
        double slidesPower = 0.4;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        HorizontalSlide.setTargetPosition(horizontalStart);
        VerticalSlide.setTargetPosition(verticalStart);

        //VerticalSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();
        while (opModeIsActive()) {

            HorizontalSlide.setTargetPositionTolerance(15);
            VerticalSlide.setTargetPositionTolerance(15);


            HorizontalSlide.setPower(slidesPower);
            VerticalSlide.setPower(slidesPower);



            if (gamepad2.a)
            {
                VerticalSlide.setTargetPosition(verticalStart);
            }
            /*
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
            }*/
            else if (gamepad2.y)
            {   //Fully extended is 3898
                VerticalSlide.setTargetPosition(basket2);
                //VerticalSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            else if (gamepad2.x)
            {
                VerticalSlide.setTargetPosition(basket1);
            }

            /*if (VerticalSlide.getCurrentPosition() < 1700) {
                VerticalSlide.setTargetPosition((int) (VerticalSlide.getCurrentPosition() - gamepad2.left_stick_y * 2000));
            }*/

            if (HorizontalSlide.getCurrentPosition() < horizontalMax) {
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
            /*if (gamepad1.x)
            {
                TopGrabber.setPosition(tipPos);
            }
            else if (gamepad1.b)
            {
                TopGrabber.setPosition(levelPos);
            }
            if (gamepad2.dpad_down)
            {

            }*/


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

