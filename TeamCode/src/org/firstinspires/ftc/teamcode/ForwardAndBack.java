package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Forward and Back", group = "Samples")
public class ForwardAndBack extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        double motorPower = 0.0;

        DcMotor m1 = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor m2 = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor m3 = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor m4 = hardwareMap.dcMotor.get("back_right_motor");
        DcMotor[] motors = {m1,m2,m3,m4};

        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Hello World!");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {

            if(gamepad1.y) {
                motorPower = 1.0;
            } else if(gamepad1.a){
                motorPower = -1.0;
            } else {
                motorPower = -gamepad1.left_stick_y;
            }

            for(DcMotor motor : motors){
                motor.setPower(motorPower);
            }

            telemetry.addData("Motor Power", motorPower);
            telemetry.update();
        }
    }
}
