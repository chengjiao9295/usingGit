import java.math.BigDecimal;
import java.util.Date;

public class hello {
    //url https://github.com/chengjiao9295/usingGit.git
    public static void main(String []args){
<<<<<<< HEAD
        System.out.print("aaaaa");
        System.out.print("bbbbb");
        System.out.print("ccccc");
        System.out.print("ddddd");
        System.out.print("eee");
        System.out.print("practice git add");
        //git add src/main/java/hello.java
        //ddddddddddd
        //sssss
        System.out.print("merge into master;now the branch is on the newBran");
        System.out.print("given that someone hava commited a new code before you commit");
        System.out.print("you also modified the code");
        System.out.print("given that someone else hava commited a new code before you commit");
        System.out.print("given that someone else hava commited a new code before you commit");
=======

        Class<?> clazz = Integer.class;
        String value="";
        Object _value = null;
        if (null == clazz || clazz.isInstance(value)) {
            _value = value;
        } else if (String.class.isInstance(value)) {
            if (Integer.class.equals(clazz)) {
                _value = Integer.valueOf((String) value);
            } else if (BigDecimal.class.equals(clazz)) {
                _value = new BigDecimal((String) value);
            }else if (Boolean.class.equals(clazz)) {
                _value = new Boolean((String) value);
            } else if (Date.class.equals(clazz)) {
                _value = new Date(Long.parseLong((String) value));
            }else if (Long.class.equals(clazz)) {
                _value = Long.parseLong((String) value);
            } else {
                throw new RuntimeException("Invalid data format : " );
            }
        } else {
            throw new RuntimeException("Invalid data format : " );
        }
        System.out.print(_value);
>>>>>>> 20190102 commit
    }

}
