package vintedHW.main;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String filePath = "/input.txt";
        List<String> result = Processor.process(filePath);
        System.out.println(result.stream().collect(Collectors.joining("\n")));
    }

}