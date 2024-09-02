package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


/**
 * Sample Button. Demonstrates how to use a toggle flag to only catch one button press.
 * This is useful if you want to use a button to turn something on and off like a switch.
 */
@TeleOp(name="SampleButton")
public class SampleButton extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        int buttonPressCount = 0;

        // Part 2
        // Add this for toggle
        // boolean buttonPressed= false;

        waitForStart();

        while(opModeIsActive()){

            //  Part 2 - Comment this out
            // Without toggle comment this out to show toggle
            if (gamepad1.a){
                buttonPressCount++;
            }

            // Part 2 - Uncomment this
            // With toggle
            /*
            if (gamepad1.a && !buttonPressed){
                buttonPressed = true;
                buttonPressCount++;
            } else if (!gamepad1.a) {
                buttonPressed = false;
            }
            */

            telemetry.addData("Press count", buttonPressCount);
            telemetry.update();
        }
    }
}
