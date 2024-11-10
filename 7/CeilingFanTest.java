class CeilingFan {
    private String location;
    private String state;

    public CeilingFan(String location) {
        this.location = location;
        this.state = "OFF";
    }

    public void on() {
        state = "ON";
        System.out.println(location + " Ceiling Fan is ON");
    }

    public void off() {
        state = "OFF";
        System.out.println(location + " Ceiling Fan is OFF");
    }

    public String getState() {
        return state;
    }
}

interface Command {
    void execute();
    void undo();
}

class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}

class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.on();
    }
}

class RemoteControl {
    private Command command;
    private Command lastCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
        lastCommand = command;
    }

    public void undoButtonWasPressed() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

public class CeilingFanTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // Turn the fan on
        remote.setCommand(ceilingFanOn);
        remote.buttonWasPressed();

        // Undo the last command (turn the fan off)
        remote.undoButtonWasPressed();

        // Turn the fan off
        remote.setCommand(ceilingFanOff);
        remote.buttonWasPressed();

        // Undo the last command (turn the fan on)
        remote.undoButtonWasPressed();
    }
}

