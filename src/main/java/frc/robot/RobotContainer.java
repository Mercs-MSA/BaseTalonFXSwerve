package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.SAT.SAT;
import frc.robot.subsystems.climber.climber;
import frc.robot.Constants;
import frc.robot.Constants.SATConstants;
import frc.robot.subsystems.vision.CustomGamePieceVision;
import frc.robot.subsystems.intake.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    public final CommandXboxController driver = new CommandXboxController(0);
    public final CommandXboxController operator = new CommandXboxController(1);

    /* Subsystems */
    public final Swerve s_Swerve = new Swerve();
    public final SAT m_SAT = new SAT();
    public final Intake m_intake = new Intake();
    //public final climber m_climber = new climber();
    //public CustomGamePieceVision m_GamePieceVision = new CustomGamePieceVision("note_pipeline");
    
    // /* Commands */
    // public CommandIntakeIn commandIntakeIn = new CommandIntakeIn(m_intake);
    // public CommandIntakeOut commandIntakeOut = new CommandIntakeOut(m_intake);
    // public CommandIntakeStop commandIntakeStop = new CommandIntakeStop(m_intake);
    CommandSwerveGoToHeading swerveYawAlignment = new CommandSwerveGoToHeading(s_Swerve);
    // public CommandSwerveGoToHeading commandSwerveHeading0 = new CommandSwerveGoToHeading(0, s_Swerve);
    // public CommandSwerveGoToHeading commandSwerveHeading90 = new CommandSwerveGoToHeading(90, s_Swerve);
    // public CommandSwerveGoToHeading commandSwerveHeading180 = new CommandSwerveGoToHeading(180, s_Swerve);
    // public CommandSwerveGoToHeading commandSwerveHeading270 = new CommandSwerveGoToHeading(270, s_Swerve);
    // public CommandNoteIntake commandNoteIntake = new CommandNoteIntake(s_Swerve, m_intake, m_GamePieceVision);
    
    // public CommandBasesPosition commandGoToBasePodiumPosition = new CommandBasesPosition("Podium", m_SAT);
    // public CommandBasesPosition commandGoToBaseSubPosition = new CommandBasesPosition("Sub", m_SAT);
    // public CommandBasesPosition commandGoToBaseTrapPosition = new CommandBasesPosition("Trap", m_SAT);
    // public CommandBasesPosition commandGoToBaseZeroPosition = new CommandBasesPosition("Zero", m_SAT);
    // public CommandBasesPosition commandGoToBaseAmpPosition = new CommandBasesPosition("Amp", m_SAT);
    // public CommandBasesPosition commandGoToBaseWingPosition = new CommandBasesPosition("Wing", m_SAT);
    // public CommandPivotPosition commandGoToPivotPodiumPosition = new CommandPivotPosition("Podium", m_SAT);
    // public CommandPivotPosition commandGoToPivotSubPosition = new CommandPivotPosition("Sub", m_SAT);
    // public CommandPivotPosition commandGoToPivotTrapPosition = new CommandPivotPosition("Trap", m_SAT);
    // public CommandPivotPosition commandGoToPivotZeroPosition = new CommandPivotPosition("Zero", m_SAT);
    // public CommandPivotPosition commandGoToPivotAmpPosition = new CommandPivotPosition("Amp", m_SAT);
    // public CommandPivotPosition commandGoToPivotWingPosition = new CommandPivotPosition("Wing", m_SAT);

    /* AutoChooser */
    public final SendableChooser<Command> autoChooser = AutoBuilder.buildAutoChooser("New Auto"); // Default auto will be `Commands.none()`;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getLeftY(), 
                () -> -driver.getLeftX(), 
                () -> -driver.getRightX(), 
                () -> false
            )
        );

        //Pathplanner commands - templates
        NamedCommands.registerCommand("marker1", Commands.print("Finished 2 Piece"));
        NamedCommands.registerCommand("marker2", Commands.print("Finished 3-4 Piece"));

        // NamedCommands.registerCommand("Start Intake", commandIntakeIn);
        // NamedCommands.registerCommand("Stop Intake", commandIntakeStop);
        // NamedCommands.registerCommand("Reverse Intake", commandIntakeOut);

        // NamedCommands.registerCommand("Go To Podium Positon", Commands.runOnce(() -> m_SAT.goToBasePodiumPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To AMP Positon", Commands.runOnce(() -> m_SAT.goToBaseAmpPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Sub Positon", Commands.runOnce(() -> m_SAT.goBaseToSubPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Trap Positon", Commands.runOnce(() -> m_SAT.goToBaseTrapPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Zero Positon", Commands.runOnce(() -> m_SAT.goToBaseZeroPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Base Podium Positon", Commands.runOnce(() -> m_SAT.goToBasePodiumPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Base AMP Positon", Commands.runOnce(() -> m_SAT.goToBaseAmpPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Base Sub Positon", Commands.runOnce(() -> m_SAT.goToBaseSubPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Base Trap Positon", Commands.runOnce(() -> m_SAT.goToBaseTrapPosition(), m_SAT));
        // NamedCommands.registerCommand("Go To Base Zero Positon", Commands.runOnce(() -> m_SAT.goToBaseZeroPosition(), m_SAT));
        

        //  NamedCommands.registerCommand("Go To Pivot Podium Positon", Commands.runOnce(() -> m_SAT.goToPivotPodiumPosition(), m_SAT));
        //  NamedCommands.registerCommand("Go To Pivot AMP Positon", Commands.runOnce(() -> m_SAT.goToPivotAmpPosition(), m_SAT));
        //  NamedCommands.registerCommand("Go To Pivot Sub Positon", Commands.runOnce(() -> m_SAT.goToPivotSubPosition(), m_SAT));
        //  NamedCommands.registerCommand("Go To Pivot Trap Positon", Commands.runOnce(() -> m_SAT.goToPivotTrapPosition(), m_SAT));
        //  NamedCommands.registerCommand("Go To Pivot Zero Positon", Commands.runOnce(() -> m_SAT.goToPivotZeroPosition(), m_SAT));
        configureButtonBindings();
    
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    public void configureButtonBindings() {
        /* Driver Buttons */
        // driver.y()
        //    .onTrue(new InstantCommand(() -> s_Swerve.zeroHeading(), s_Swerve));  /// suggest commenting this out while we troubleshoot this
         
        // driver.povUp()
        //     .onTrue(commandSwerveHeading0);
        // driver.povLeft()
        //     .onTrue(commandSwerveHeading90);
        // driver.povDown()
        //     .onTrue(commandSwerveHeading180);
        // driver.povRight()
        //     .onTrue(commandSwerveHeading270);

        // driver.a()
        //     .onTrue(commandNoteIntake);
        // driver.a()
        //     .onTrue(commandNoteIntake);

        // driver.leftTrigger()
        //     .onTrue(Commands.runOnce(() -> m_SAT.shootNote(), m_SAT));
        // driver.leftTrigger()
        //     .onTrue(Commands.runOnce(() -> m_SAT.shootNote(), m_SAT));


            // operator.x()
            // .onTrue(
            //     Commands.runOnce(() -> m_SAT.goToPivotAmpPosition(), m_SAT)
            // .andThen(Commands.runOnce(() -> m_SAT.goToBaseAmpPosition(), m_SAT))
            // );
        /* Operator Buttons */
        // operator.a()
        //     .onTrue(commandGoToBaseZeroPosition.andThen(commandGoToPivotZeroPosition));
        
        // operator.b()
        //     .and(operator.axisGreaterThan(1, 0.6))
        //     .and(operator.axisLessThan(0, 0.4))
        //     .and(operator.axisGreaterThan(0, -0.4))
        //     .onTrue(commandGoToBasePodiumPosition.andThen(commandGoToPivotPodiumPosition));

        // operator.b()
        //     .and(operator.axisLessThan(1, -0.6))
        //     .and(operator.axisLessThan(0, 0.4))
        //     .and(operator.axisGreaterThan(0, -0.4))
        //     .onTrue(commandGoToBaseSubPosition.andThen(commandGoToPivotSubPosition));
        
        // operator.b()
        //     .and(operator.axisLessThan(0, -0.6))
        //     .and(operator.axisLessThan(1, 0.4))
        //     .and(operator.axisGreaterThan(1, -0.4))
        //     .onTrue(commandGoToBaseTrapPosition.andThen(commandGoToPivotTrapPosition));

        // operator.b()
        //     .and(operator.axisGreaterThan(0, 0.6))
        //     .and(operator.axisLessThan(1, 0.4))
        //     .and(operator.axisGreaterThan(1, -0.4))
        //     .onTrue(commandGoToBaseAmpPosition.andThen(commandGoToPivotAmpPosition));

        // operator.start()
        //     .onTrue(commandIntakeIn);
        
        // operator.back()
        //     .onTrue(commandIntakeOut); // not reporting to SmartDashboard

        driver.leftBumper()
            .whileTrue(swerveYawAlignment);
        
        // operator.start()
        //     .and(operator.back())
        //     .onTrue(commandIntakeStop);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}