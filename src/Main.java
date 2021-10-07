import java.util.*;

public class Main {
    public static Scanner scanner =  new Scanner(System.in);
    public static void main(String[] args) {
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] toks = input.trim().split(" ");
            for (String tok : toks) {
                judgeAll(tok);
            }
        }
    }
    public static void judgeAll(String in){
        if(!(in.length()>0))
            return;
        if(in.replace(" ", "").equals(""))
            return;
        if(Character.isDigit(in.charAt(0))){
            judgeNumber(in);
        }
        else if(Character.isLetter(in.charAt(0))||in.charAt(0)=='_'){
            judgeWord(in);
        }
        else {
            judgeOther(in);
        }
    }
    public static void judgeNumber(String in){
        int i=0;
        for(;i<in.length();i++){
            if(!Character.isDigit(in.charAt(i))){
                break;
            }
        }
        String out = in.substring(0,i);
        System.out.println("Number("+out+")");
        if(i<=in.length()-1){
            String temp = in.substring(i);
            judgeAll(temp.trim());
        }
    }
    public static void judgeWord(String in){
        int i=0;
        for(;i<in.length();i++){
            if(!(Character.isLetter(in.charAt(i))||in.charAt(i)=='_'||Character.isDigit(in.charAt(i)))){
                break;
            }
        }
        String out = in.substring(0,i);

        if(out.equals("if")){
            System.out.println("If");
        }
        else if(out.equals("else")){
            System.out.println("Else");
        }
        else if(out.equals("while")){
            System.out.println("While");
        }
        else if(out.equals("break")){
            System.out.println("Break");
        }
        else if(out.equals("continue")){
            System.out.println("Continue");
        }
        else if(out.equals("return")){
            System.out.println("Return");
        }
        else{
            System.out.println("Ident("+out+")");
        }
        if(i<=in.length()-1){
            String temp = in.substring(i);
            judgeAll(temp.trim());
        }
    }
    public static void judgeOther(String in){
        if(in.startsWith("==")){
            System.out.println("Eq");
            if(in.length()>2)
                judgeAll(in.substring(2).trim());
        }
        else if(in.charAt(0)=='='){
            System.out.println("Assign");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)==';'){
            System.out.println("Semicolon");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='('){
            System.out.println("LPar");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)==')'){
            System.out.println("RPar");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='{'){
            System.out.println("LBrace");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='}'){
            System.out.println("RBrace");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='+'){
            System.out.println("Plus");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='*'){
            System.out.println("Mult");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='/'){
            System.out.println("Div");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='>'){
            System.out.println("Gt");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else if(in.charAt(0)=='<'){
            System.out.println("Lt");
            if(in.length()>1)
                judgeAll(in.substring(1).trim());
        }
        else {
            System.out.println("Err");
            System.exit(0);
        }
    }
}