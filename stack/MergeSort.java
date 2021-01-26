import java.util.Random;

public class MergeSort{
    public static void main(String[] args) {
        int[] toSort = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            toSort[i] = (random.nextInt(100));
            System.out.print(toSort[i] + " ");
        }

        System.out.println();

        toSort = mergeSort(toSort);
        for (int i = 0; i < 20; i++){
            System.out.print(toSort[i] + " ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] a){
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        for (int i = 0; i < a.length; i++){
            int[] temp = {a[i]};
            stack1.push(temp);
        }

        while (stack1.getSize() > 1){
            while (stack1.getSize() > 1){
                int[] l = (int[]) stack1.pop();
                int[] r = (int[]) stack1.pop();
                stack2.push(merge(l, r));
            }

            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            while (stack2.getSize() > 1){
                int[] l = (int[]) stack2.pop();
                int[] r = (int[]) stack2.pop();
                stack1.push(merge(l, r));
            }

            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return (int[]) stack1.pop();
    }

    public static int[] merge(int[] b, int[] c){
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        int[] a = new int[b.length + c.length];
        while (bIndex < b.length && cIndex < c.length){
            if (b[bIndex] < c[cIndex]){
                a[aIndex++] = b[bIndex++];
            }
            else{
                a[aIndex++] = c[cIndex++];
            }
        }
        while (bIndex < b.length){
            a[aIndex++] = b[bIndex++];
        }
        while (cIndex < c.length){
            a[aIndex++] = c[cIndex++];
        }
        return a;
    }
}