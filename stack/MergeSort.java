import java.util.Random;

public class MergeSort{
    public static void main(String[] args) {
        Stack toSort = new Stack();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            toSort.push(random.nextInt(40));
        }
        System.out.println(toSort);
        mergeSort(toSort);
        System.out.println(toSort);
    }

    public static void mergeSort(Stack stack){
        if (stack == null) throw new IllegalArgumentException();
        if (stack.getSize() == 1) return;

        int mid = stack.getSize() / 2;

        Stack left = new Stack();
        Stack right = new Stack();

        int max = stack.getSize() - mid;

        for (int i = 0; i < max; i++){
            right.push(stack.pop());
        }

        max = mid;

        for (int i = 0; i < max; i++){
            left.push(stack.pop());
        }

        mergeSort(left);
        mergeSort(right);

        merge(stack, left, right);
    }

    public static void merge(Stack stack, Stack left, Stack right){
        Stack leftHelper = new Stack();
        Stack rightHelper = new Stack();

        while (!left.isEmpty()){  // rovescio gli stack
            leftHelper.push(left.pop());
        }

        while (!right.isEmpty()){
            rightHelper.push(right.pop());
        }

        while (!leftHelper.isEmpty() && !rightHelper.isEmpty()){
            if (leftHelper.top().compareTo(rightHelper.top()) < 0){
                stack.push(leftHelper.pop());
            }
            else{
                stack.push(rightHelper.pop());
            }
        }

        while (!leftHelper.isEmpty()){
            stack.push(leftHelper.pop());
        }

        while (!rightHelper.isEmpty()){
            stack.push(rightHelper.pop());
        }
    }
}