package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

    /* Subsystems */
    public Swerve s_Swerve = new Swerve();


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));  /// suggest commenting this out while we troubleshoot this
    }


    // paths to test 

    public Command getAutonomousCommand() {
        // Load the path you want to follow using its name in the GUI
        //spline path (test last)
        //PathPlannerPath path = PathPlannerPath.fromPathFile("static.path");


        // move forward ()
        // PathPlannerPath path = PathPlannerPath.fromPathFile("New Path");

        // move left (test 3rd)
        // PathPlannerPath path = PathPlannerPath.fromPathFile("New New Path");

        // doesn't move (test 1st)
        // PathPlannerPath path = PathPlannerPath.fromPathFile("New New New Path");

        // Create a path following command using AutoBuilder. This will also trigger event markers.
<<<<<<< HEAD
        return s_Swerve.getAutonomousCommand("goLeft", true);
=======
        return s_Swerve.getAutonomousCommand("static", true);
>>>>>>> 16a1f15212f955c9436130b6c49edc3d62028b6d
    }

    // autos to test
    // /**
    //  * Use this to pass the autonomous command to the main {@link Robot} class.
    //  *
    //  * @return the command to run in autonomous
    //  */
    // public Command getAutonomousCommand() {
    //     // An ExampleCommand will run in autonomous
           // New Auto is just the spline path
           // New New Auto is move left path
           // New New New Auto is move forward (TEST SPLINE PATH LAST )
    //     return new PathPlannerAuto("New Auto");
    // }

    // /**
    //  * Get the path follower with events.
    //  *
    //  * @param pathName       PathPlanner path name.
    //  * @param setOdomToStart Set the odometry position to the start of the path.
    //  * @return {@link AutoBuilder#followPathWithEvents(PathPlannerPath)} path command.
    //  */
    // public void getAutonomousCommand(String pathName, boolean setOdomToStart) {
    //     s_Swerve.getAutonomousCommand(pathName, setOdomToStart);
    // }
}