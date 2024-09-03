package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SampleMecanum")
public class SampleMecanum extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        // Get the motors
        DcMotor front_left = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right_motor");

        // Reverse the motors on the left side
        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            // Store the values
            double left_stick_y = -gamepad1.left_stick_y;
            double left_stick_x = gamepad1.left_stick_x;
            double triggers = gamepad1.left_trigger - gamepad1.right_trigger;

            // Set the power on the motors
            front_left.setPower(left_stick_y + left_stick_x - triggers);
            front_right.setPower(left_stick_y - left_stick_x + triggers);
            back_left.setPower(left_stick_y - left_stick_x - triggers);
            back_right.setPower(left_stick_y + left_stick_x + triggers);
        }
    }
}
