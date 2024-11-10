class Light {
    public void on() {
        System.out.println("The light is on");
    }

    public void off() {
        System.out.println("The light is off");
    }
}

class Fan {
    public void on() {
        System.out.println("The fan is on");
    }

    public void off() {
        System.out.println("The fan is off");
    }
}

interface Command {
    void execute();
    void undo();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}

class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command lastCommand;

    public RemoteControl() {
        onCommands = new Command[2];
        offCommands = new Command[2];
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        FanOnCommand ceilingFanOn = new FanOnCommand(ceilingFan);
        FanOffCommand ceilingFanOff = new FanOffCommand(ceilingFan);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, ceilingFanOn, ceilingFanOff);

        // Test the commands
        System.out.println("Testing Remote Control:");
        remote.onButtonWasPressed(0); // Turn on the light
        remote.offButtonWasPressed(0); // Turn off the light
        remote.onButtonWasPressed(1); // Turn on the fan
        remote.offButtonWasPressed(1); // Turn off the fan
        remote.undoButtonWasPressed(); // Undo last command (turn off fan)
    }
}

