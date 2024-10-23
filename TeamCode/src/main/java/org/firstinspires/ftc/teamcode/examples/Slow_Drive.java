package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@TeleOp(name = "Slow_Drive")
public class Slow_Drive extends LinearOpMode
{
    private DcMotor MotorFR;
    private DcMotor MotorFL;
    private DcMotor MotorBR;
    private DcMotor MotorBL;

    @Override
    public void runOpMode()
    {
        MotorFR = hardwareMap.get(DcMotor.class, "MotorFR");
        MotorFL = hardwareMap.get(DcMotor.class, "MotorFL");
        MotorBR = hardwareMap.get(DcMotor.class, "MotorBR");
        MotorBL = hardwareMap.get(DcMotor.class, "MotorBL");

        MotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        boolean ReverseDrive = false;

        waitForStart();
        while (opModeIsActive()) {

            // Below is the motor tests
            //PowerFR = gamepad1.a ? 1.0 : 0.0;  // A
            //PowerFL = gamepad1.y ? 1.0 : 0.0;  // Y
            //PowerBR = gamepad1.b ? 1.0 : 0.0;  // B
            //PowerBL = gamepad1.x ? 1.0 : 0.0;  // X

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
        }}}