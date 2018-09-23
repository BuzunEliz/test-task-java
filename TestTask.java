import java.util.Scanner;

/**
 * Created by Елизавета on 23.09.2018.
 */
public class TestTask {
    static int minNumAction(int line[],int k)
    {
        int count=0;
        if(k<0) {
            k*=(-1);
            count+=1;
        }
        if(line[k]==0&&k!=0){
            int temp_x=0, v=1;
            while(temp_x<k){
                temp_x+=v;
                count++;
                line[temp_x]=count;
                v*=2;
            }
            //вычисление ближайших позиций, в которые можно попасть, используя инструкции A
            int next=v-1;
            int prev=v/2-1;
            //нахождение расстояний между текущей позицией и найденными выше
            int d_next=next-k;
            int d_prev=k-prev;

            if(d_next==0)
            {
                return count;
            }
            //определение минимального количества команд, позволяющих пройти найденные расстояния
            if(line[d_next]==0) line[d_next]=minNumAction(line,d_next);
            if(line[d_prev]==0) line[d_prev]=minNumAction(line,d_prev);
            if(line[d_prev]+2<line[d_next]+1){
                count=count+line[d_prev]+2;
            }
            else{
                count=count+line[d_next]+1;
            }
            line[k]=count;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int k = in.nextInt();
        int temp_x=0, v=1;
        while(temp_x<k){
            temp_x+=v;
            v*=2;
        }
        int[] line=new int[v];
        System.out.println("Минимальное количество команд для достижения позиции "+k+" : "+minNumAction(line,k));
    }
}
