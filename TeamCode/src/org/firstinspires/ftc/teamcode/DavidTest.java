package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.joebotics.HelloWorld;

@TeleOp(name="David")
public class DavidTest extends LinearOpMode {

    HelloWorld myHelloWorld;
    @Override
    public void runOpMode() throws InterruptedException {
        myHelloWorld = new HelloWorld(this);
        double answer = Math.pow(2, 4);
        answer = Math.sqrt(answer);
        telemetry.addLine("Hello World");
        telemetry.addData("Answer", answer);
        telemetry.update();

        waitForStart();
        int counter = 0;
        while(opModeIsActive()){
            //counter++;
            //telemetry.addData("Counter",counter);
            myHelloWorld.Update();
            telemetry.update();
        }
    }
}
