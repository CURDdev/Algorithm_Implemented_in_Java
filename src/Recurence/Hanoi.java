package Recurence;

public class Hanoi {
    public void move(int diskNum, String from, String mid, String to){
        if(diskNum == 1){
            System.out.println("Move from " + from + " to " + to);
        }
        else {
            //先把最左边上边的n-1个盘子通过最右边挪到中间柱子上，再把最左边的最后一个盘子挪到最右边，最后再把中间柱子上的n-1个盘子通过最左边的柱子挪到最右边
            move(diskNum - 1, from, to, mid);
            System.out.println("Move from " + from + " to " + to);
            move(diskNum - 1, mid, from, to);
        }
    }
    public static void main(String[] args){
        Hanoi hanoi = new Hanoi();
        hanoi.move(3,"left", "mid", "right");
    }
}
