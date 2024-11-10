// Step 1: Define the components of the home theater system

class Amplifier {
    public void on() {
        System.out.println("Amplifier is on.");
    }

    public void off() {
        System.out.println("Amplifier is off.");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void off() {
        System.out.println("Projector is off.");
    }

    public void setInput(String input) {
        System.out.println("Setting projector input to " + input);
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is down.");
    }

    public void up() {
        System.out.println("Screen is up.");
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void off() {
        System.out.println("DVD Player is off.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping the movie.");
    }
}

// Step 2: Create the HomeTheaterFacade
class HomeTheaterFacade {
    private Amplifier amplifier;
    private Projector projector;
    private Screen screen;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Amplifier amplifier, Projector projector, Screen screen, DVDPlayer dvdPlayer) {
        this.amplifier = amplifier;
        this.projector = projector;
        this.screen = screen;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch a movie...");
        screen.down();
        projector.on();
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        screen.up();
    }
}

// Step 3: Create a main class to demonstrate the Facade Pattern
public class FacadePatternDemo {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();
        DVDPlayer dvdPlayer = new DVDPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amplifier, projector, screen, dvdPlayer);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}

