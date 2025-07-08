package fr.algorithmie;

public class CaractereConsecutif {
    public static void main(String[] args) {
        String text = "aaaabbbcccdeee";
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < text.length(); i++){
            if (text.charAt(i) == text.charAt(i - 1)){
                count++;
            } else {
                result.append(text.charAt(i-1)).append(count);
                count = 1;
            }
        }
        result.append(text.charAt(text.length()-1)).append(count);
        System.out.println(text +" becomes " + result);
    }
}
