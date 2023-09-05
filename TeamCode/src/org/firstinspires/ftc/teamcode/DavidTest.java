package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="David")
public class DavidTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addLine("Hello World");
        telemetry.update();
        waitForStart();
        int counter = 0;
        while(opModeIsActive()){
            counter++;
            telemetry.addData("Counter",counter);
            telemetry.update();
        }
    }
}
