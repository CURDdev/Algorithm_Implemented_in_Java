package StringProblem;

public class ReverseString {
    public String reverseWithFrontZero(String input){
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for(int i = input.length() - 1; i >= 0; i--){
            if((flag == false) && (input.charAt(i) == '0')){
                continue;
            }
            flag = true;
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseWithFrontZero("000220022"));
    }
}
