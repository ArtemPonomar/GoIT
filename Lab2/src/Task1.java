public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        final String sentence = "We have the java learning course!";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++){
            System.out.print(words[i] + " ");
            Thread.sleep(1000);
        }
    }
}
