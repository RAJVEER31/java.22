import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of rows: ");
        int n = sc.nextInt();
        System.out.println("enter the number of columns: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("enter the element at position" + i +  j );
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the ring number: ");
        int sno = sc.nextInt();
        System.out.println("enter the number of rotations: ");
        int rno = sc.nextInt();
        ringrotate(arr,sno,rno);
        display(arr);
    }
    public static void ringrotate(int[][] arr,int sno,int rno) {
        int[]la =  fill_1d_from_2d(arr, sno);
        rotate_1d(la,rno);
        fill_2d_from_1d(arr, sno, la);
    }
    public static int[] fill_1d_from_2d (int[][] arr, int sno) {
        int rmin = sno - 1;
        int cmin = sno - 1;
        int rmax = arr.length - sno;
        int cmax = arr[0].length - sno;
        int sz = 2*(rmax-rmin+ cmax-cmin);
        int la[] = new int [sz];
        int idx = 0;
        for (int row= rmin; row <= rmax; row++) {
            la[idx] = arr[row][cmin];
            idx++;
        }
        cmin++;
        for (int col = cmin; col <= cmax; col++) {
            la[idx] = arr[rmax][col];
            idx++;
        }
        rmax--;
        for (int row = rmax; row >= rmin; row--) {
            la[idx] = arr[row][cmax];
            idx++;
        }
        cmax--;
        for (int col = cmax; col >= cmin; col++) {
            la[idx] = arr[rmin][col];
            idx++;
        }
        rmin++;
        return la;
    }
    public static void rotate_1d(int[] la, int rno) {
        rno = rno % la.length;
        if (rno < 0) {
            rno = la.length + rno;
        }
        reverse(la,0,la.length-1);
        reverse(la,0,rno-1);
        reverse(la,rno,la.length-1);
    }
    public static void reverse(int[] la, int i, int j) {
        while (i < j) {
            int temp = la[i];
            la[i] = la[j];
            la[j] = temp;
            i++;
            j--;
        }
    }
    public static void fill_2d_from_1d(int[][]arr,int sno, int[] la) {
        int rmin = sno - 1;
        int cmin = sno - 1;
        int rmax = arr.length - sno;
        int cmax = arr[0].length - sno;
        int idx = 0;
        for (int row = rmin; row <= rmax; row++) {
            arr[row][cmin] = la[idx];
            idx++;
        }
        cmin++;
        for (int col = cmin; col <= cmax; col++) {
            arr[rmax][col] = la[idx];
            idx++;
        }
        rmax--;
        for (int row = rmax; row >= rmin; row--) {
            arr[row][cmax] = la[idx];
            idx++;
        }
        cmax--;
        for (int col = cmax; col >= cmin; col--) {
            arr[rmin][col] = la[idx];
            idx++;
        }
        rmin++;
    }
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
