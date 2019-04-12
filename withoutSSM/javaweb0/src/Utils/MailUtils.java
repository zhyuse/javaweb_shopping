package Utils;

import snnu.zhyuse.mymail.MyMail;

public class MailUtils {

    //详细发送方法见MyMail
    public static void main(String[] args){
        MyMail myMail=new MyMail();
        System.out.println(myMail.send("823727019@qq.com"));
    }
}
