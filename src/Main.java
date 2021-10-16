import java.util.*;

public class Main {
    public static Scanner scanner =  new Scanner(System.in);
    public static void main(String[] args) {
        String s = scanner.nextLine();
        s=s.replace(" ","");
        s=s.replace("\t","");
        //System.out.println(s);
        if(!(s.equals("intmain(){"))){
            System.exit(1);
        }
        System.out.println("define dso_local i32 @main(){");
        if(!scanner.hasNext()){
            System.exit(1);
        }
        s = scanner.nextLine();
        String[] arg = s.trim().split(" ");
        if(!(arg[0].trim().equals("return"))){
            System.exit(1);
        }
        if(!judgeNumber(arg[1].trim())){
            System.exit(1);
        }
        System.out.println("    ret i32 "+arg[1].substring(0,arg[1].length()-1));
        if(!scanner.hasNext()){
            System.exit(1);
        }
        s = scanner.nextLine();
        s=s.replace(" ","");
        s=s.replace("\t","");
        if(!(s.trim().equals("}"))){
            System.exit(1);
        }
        System.out.println("}");
    }
    public static boolean judgeNumber(String in){
        in=in.trim();
        if(in.charAt(0)=='0'){
            if(in.length()>1&&(in.charAt(1)=='x'||in.charAt(1)=='X')){
                for(int i=0;i<in.length()-1;i++){
                    if(!(Character.isDigit(in.charAt(i))||(in.charAt(i)>='a'&&in.charAt(i)<='f')||(in.charAt(i)>='A'&&in.charAt(i)<='F'))){
                        return false;
                    }
                }
            }
            else {
                for(int i=0;i<in.length()-1;i++){
                    if(!((in.charAt(i)>='0'&&in.charAt(i)<='7'))){
                        return false;
                    }
                }
            }
        }
        else {
            for(int i=0;i<in.length()-1;i++){
                if(!(Character.isDigit(in.charAt(i)))){
                    return false;
                }
            }
        }
        return in.charAt(in.length() - 1) == ';';
    }
}