package org.firstinspires.ftc.teamcode.working_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Reverse_Mecanum")
public class Reverse_Drive extends LinearOpMode
{
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;
    private CRServo Grabber;

    @Override
    public void runOpMode()
    {
        MotorFR = hardwareMap.get(DcMotor.class, "MotorFR");
        MotorFL = hardwareMap.get(DcMotor.class, "MotorFL");
        MotorBR = hardwareMap.get(DcMotor.class, "MotorBR");
        MotorBL = hardwareMap.get(DcMotor.class, "MotorBL");
        Grabber = hardwareMap.get(CRServo.class, "Grabber");

        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        boolean ReverseDrive = false;

        waitForStart();
        while (opModeIsActive()) {

            if (gamepad1.x) {
                ReverseDrive = true;
            } if (gamepad1.y) {
                ReverseDrive = false;
            }

            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double max = Math.max(Math.abs(strafe) + Math.abs(drive) + Math.abs(turn), 1);


            double PowerFL = ((drive + strafe + turn) / max);
            double PowerBL = ((drive - strafe + turn) / max);
            double PowerFR = ((drive - strafe - turn) / max);
            double PowerBR = ((drive + strafe - turn) / max);



            if (ReverseDrive) {
                PowerFL = -PowerFL;
                PowerBL = -PowerBL;
                PowerFR = -PowerFR;
                PowerBR = -PowerBR;
            }
            // Below is the motor tests
//            PowerFR = gamepad1.a ? 1.0 : 0.0;  // A
//            PowerFL = gamepad1.y ? 1.0 : 0.0;  //
//            PowerBR = gamepad1.b ? 1.0 : 0.0;  // B
//            PowerBL = gamepad1.x ? 1.0 : 0.0;  // X
            // Servo tests
            /*
                if (gamepad1.a) {
                    Grabber.setPower(1);
            }
                if (gamepad1.b) {
                    Grabber.setPower(0);
                }
                //if (gamepad1.y) {
                    //Grabber.setPosition(-1);
                //}
             */
            MotorFR.setPower(PowerFR);
            MotorFL.setPower(PowerFL);
            MotorBR.setPower(PowerBR);
            MotorBL.setPower(PowerBL);
        }}}