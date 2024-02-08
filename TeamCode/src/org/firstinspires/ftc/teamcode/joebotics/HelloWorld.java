package org.firstinspires.ftc.teamcode.joebotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HelloWorld {

    OpMode myOpMode;

    public HelloWorld(LinearOpMode theOpMode){
        myOpMode = theOpMode;
    }

    public void Update()
    {
        myOpMode.telemetry.addLine("This is my test class");
    }
}
