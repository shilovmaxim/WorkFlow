import java.util.Arrays;
import java.util.stream.Collectors;

//Дана строка «Приииивееееет Сбееееерррр», необходимо вывести корректную реализацию - «Привет Сбер».
public class Hello {
    public static void main(String[] args) {
        String str = "Приииивееееет Сбеееееррррр";
        String[] splitString = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : splitString) {
            String collect = Arrays.stream(s.split(""))
                    .distinct()
                    .collect(Collectors.joining());
            stringBuilder.append(collect).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}

