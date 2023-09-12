package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="MyMecanumDemo")
public class MyMecanumDemo extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor front_left = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right_motor");

        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()){
            double left_stick_y = 0;//-gamepad1.left_stick_y;
            double left_stick_x = 0;//gamepad1.left_stick_x;
            double triggers = gamepad1.left_trigger - gamepad1.right_trigger;

            front_left.setPower(left_stick_y + left_stick_x - triggers);
            front_right.setPower(left_stick_y - left_stick_x + triggers);
            back_left.setPower(left_stick_y - left_stick_x - triggers);
            back_right.setPower(left_stick_y + left_stick_x + triggers);

            telemetry.addData("left_stick_y", left_stick_y);
            telemetry.addData("left_stick_x", left_stick_x);
            telemetry.addData("triggers", triggers);
            telemetry.update();
        }
        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }
}
