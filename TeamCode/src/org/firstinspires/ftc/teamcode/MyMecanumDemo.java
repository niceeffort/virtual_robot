package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.navigation.*;

@TeleOp(name="MyMecanumDemo")
public class MyMecanumDemo extends LinearOpMode {
    enum orientationTypes {FIELD_CENTRIC, ROBOT_CENTRIC}
    private final orientationTypes orientationMode = orientationTypes.FIELD_CENTRIC;

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor front_left = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right_motor");
        IMU imu = hardwareMap.get(IMU.class, "imu");

        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()){
            double left_stick_y = -gamepad1.left_stick_y;
            double left_stick_x = gamepad1.left_stick_x;
            double triggers = gamepad1.left_trigger - gamepad1.right_trigger;

            float robotHeading = imu.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS).firstAngle;

            if(orientationMode == orientationTypes.FIELD_CENTRIC){
              double orig_left_stick_y = left_stick_y;
              double orig_left_stick_x = left_stick_x;
              left_stick_x = orig_left_stick_x * Math.cos(-robotHeading) - orig_left_stick_y * Math.sin(-robotHeading);
              left_stick_y = orig_left_stick_x * Math.sin(-robotHeading) + orig_left_stick_y * Math.cos(-robotHeading);
            }

            front_left.setPower(left_stick_y + left_stick_x - triggers);
            front_right.setPower(left_stick_y - left_stick_x + triggers);
            back_left.setPower(left_stick_y - left_stick_x - triggers);
            back_right.setPower(left_stick_y + left_stick_x + triggers);

            telemetry.addData("left_stick_y", left_stick_y);
            telemetry.addData("left_stick_x", left_stick_x);
            telemetry.addData("triggers", triggers);
            telemetry.addData("heading", robotHeading * 180.0 / Math.PI);
            telemetry.update();
        }
        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }
}
