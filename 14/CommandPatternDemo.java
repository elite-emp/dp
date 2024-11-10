// Step 1: Define the Command interface
interface Command {
    void execute();
}

// Step 2: Implement Concrete Commands
class Light {
    public void on() {
        System.out.println("The light is ON");
    }

    public void off() {
        System.out.println("The light is OFF");
    }
}

class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class GarageDoor {
    public void up() {
        System.out.println("The garage door is UP");
    }

    public void down() {
        System.out.println("The garage door is DOWN");
    }
}

class GarageDoorUpCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}

class Stereo {
    public void on() {
        System.out.println("Stereo is ON");
    }

    public void off() {
        System.out.println("Stereo is OFF");
    }

    public void setCD() {
        System.out.println("CD is set in the stereo");
    }
}

class StereoOnWithCDCommand implements Command {
    private final Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
    }
}

// Step 3: Create a RemoteControl class to hold the commands
class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}

// Step 4: Create a main class to demonstrate the Command Pattern
public class CommandPatternDemo {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(garageDoorUp);
        remote.pressButton();

        Stereo stereo = new Stereo();
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);

        remote.setCommand(stereoOnWithCD);
        remote.pressButton();
    }
}

