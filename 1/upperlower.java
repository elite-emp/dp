import java.io.*;

class LowerCaseDecorator extends FilterOutputStream {
    public LowerCaseDecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        // Convert uppercase letters to lowercase
        if (b >= 'A' && b <= 'Z') {
            b = b + ('a' - 'A');
        }
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(b[i]);
        }
    }
}

public class upperlower {
    public static void main(String[] args) {
        String input = "Hello World! This Is A Test String.";
        
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             LowerCaseDecorator lowerCaseDecorator = new LowerCaseDecorator(baos)) {
            
            // Writing to the decorated output stream
            lowerCaseDecorator.write(input.getBytes());
            lowerCaseDecorator.flush();
            
            // Getting the result
            String output = baos.toString();
            System.out.println("Original: " + input);
            System.out.println("Converted: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

