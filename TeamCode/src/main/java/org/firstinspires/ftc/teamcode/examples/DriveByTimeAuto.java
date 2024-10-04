package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
@Autonomous
public class DriveByTimeAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotorSimple leftFront = hardwareMap.get(DcMotorSimple.class, "leftFront");
        DcMotorSimple leftBack = hardwareMap.get(DcMotorSimple.class, "leftBack");
        DcMotorSimple rightFront = hardwareMap.get(DcMotorSimple.class, "rightFront");
        DcMotorSimple rightBack = hardwareMap.get(DcMotorSimple.class, "rightBack");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        ElapsedTime runtime = new ElapsedTime();

        waitForStart();

        leftFront.setPower(0.5);
        leftBack.setPower(0.5);
        rightFront.setPower(0.5);
        rightBack.setPower(0.5);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            idle();
        }

        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            idle();
        }

        leftFront.setPower(-0.5);
        leftBack.setPower(-0.5);
        rightFront.setPower(0.5);
        rightBack.setPower(0.5);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            idle();
        }

        requestOpModeStop();
    }
}
