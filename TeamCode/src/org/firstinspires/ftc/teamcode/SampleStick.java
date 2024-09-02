package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Sample Stick. Demonstrates how a stick provides an analog value between -1.0 and 1.0 rather
 * than just a true/false like a button.
 */
@TeleOp(name = "SampleStick")
public class SampleStick extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        // Store the stick value in a variable
        double leftStickY = 0.0;

        waitForStart();

        while (opModeIsActive()){

            // We add a negative sign because the value is reversed
            // Pushing up on the stick is negative
            leftStickY = -gamepad1.left_stick_y;

            telemetry.addData("Left Stick Y", leftStickY);
            telemetry.update();
        }

    }
}
