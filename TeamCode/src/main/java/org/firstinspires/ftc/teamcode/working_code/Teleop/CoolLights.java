package org.firstinspires.ftc.teamcode.working_code.Teleop;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
@Disabled
@TeleOp(name = "3965Mecanum")
public class CoolLights extends LinearOpMode {

    RevBlinkinLedDriver BlinkinLed;
    RevBlinkinLedDriver.BlinkinPattern Pattern;


    RevBlinkinLedDriver blinkinLedDriver = hardwareMap.get(RevBlinkinLedDriver.class, "LED");

    //blinkinLedDriver.setPattern(RevBlinkinLedDriver.BlinkinPattern.GOLD);
    }
