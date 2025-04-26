package org.firstinspires.ftc.teamcode.working_code.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@TeleOp(name = "MecanumSlow")
public class MecanumSlow extends LinearOpMode
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

        waitForStart();
        while (opModeIsActive())
        {

        }

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
        }


    }
