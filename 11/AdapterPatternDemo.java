// Step 1: Define the BeatModel interface
interface BeatModel {
    void start();
    void stop();
    void setBPM(int bpm);
    int getBPM();
}

// Step 2: Create a class that implements BeatModel
class HeartModel implements BeatModel {
    private int bpm;

    public HeartModel() {
        bpm = 90; // Initial BPM
    }

    @Override
    public void start() {
        System.out.println("Heart is beating.");
    }

    @Override
    public void stop() {
        System.out.println("Heart stopped beating.");
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        System.out.println("BPM set to: " + bpm);
    }

    @Override
    public int getBPM() {
        return bpm;
    }
}

// Step 3: Create an interface for the Heart Model
interface HeartModelInterface {
    void pump();
}

// Step 4: Implement the HeartModelInterface
class HeartAdapter implements HeartModelInterface {
    private final HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void pump() {
        heartModel.start();
        // Simulating heart pumping
        System.out.println("Heart is pumping.");
    }

    public void stopPumping() {
        heartModel.stop();
    }

    public int getCurrentBPM() {
        return heartModel.getBPM();
    }
}

// Step 5: Create a main class to test the Adapter Pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        HeartAdapter heartAdapter = new HeartAdapter(heartModel);
        
        heartAdapter.pump();
        heartModel.setBPM(120);
        System.out.println("Current BPM: " + heartAdapter.getCurrentBPM());
        
        heartAdapter.stopPumping();
    }
}

