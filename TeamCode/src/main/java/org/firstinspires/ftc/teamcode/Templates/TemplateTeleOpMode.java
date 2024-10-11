package org.firstinspires.ftc.teamcode.Templates;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp(name = "Template Tele Op Mode")
public class TemplateTeleOpMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        // vvv Initialize hardware vvv

        // ^^^ Initialize hardware ^^^

        // Wait for start button on driver station to be pressed.
        waitForStart();

        // Teleop loop, this will run until the program is stopped by the driver station.
        while (opModeIsActive()) {
            // vvv Put tele op code here vvv

            // ^^^ Put tele op code here ^^^
        }
    }
}
