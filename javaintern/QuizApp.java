import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static Question[] questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
            // Add more questions as needed
    };
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (currentQuestionIndex < questions.length) {
            askQuestion(scanner);
        }
        System.out.println("Quiz finished! Your score is " + score + "/" + questions.length);
    }

    private static void askQuestion(Scanner scanner) {
        Question question = questions[currentQuestionIndex];
        System.out.println(question.getQuestion());
        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + question.getOptions()[i]);
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.");
                currentQuestionIndex++;
                timer.cancel();
            }
        }, 10000); // 10 seconds timer

        System.out.print("Enter your answer (1-4): ");
        int answer = scanner.nextInt();
        timer.cancel();

        if (question.isCorrect(answer - 1)) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong! The correct answer was " + question.getCorrectAnswer());
        }
        currentQuestionIndex++;
    }
}
