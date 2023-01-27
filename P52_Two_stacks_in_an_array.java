public class P52_Two_stacks_in_an_array {
    
    int top1;
    int top2;
    int size;
    int arr[];

    P52_Two_stacks_in_an_array(int size){
        this.size = size;
        top1 = -1;
        top2 = size;
        arr = new int[size];
    }

    public void pop1(){
        if(top1 >= 0){
            top1--;
        }
        else{
            System.out.println("Stack1 Underflow!!!");
        }
    }

    public void pop2(){
        if(top2 <= size-1){
            top2++;
        }
        else{
            System.out.println("Stack2 Overflow!!!");
        }
    }

    public void push1(int data){
        if(top2 - top1 > 1){
            top1++;
            arr[top1] = data;
        }
        else{
            System.out.println("Stack1 Underflow!!!");
        }
    }

    public void push2(int data){
        if(top2 - top1 > 1){
            top2--;
            arr[top2] = data;
        }
        else{
            System.out.println("Stack2 Underflow!!!");
        }
    }

    public void print(){
        System.out.print("Stack1 :- ");

        int temp = top1;
        while(temp >= 0){
            System.out.print(arr[temp] + " ");
            temp--;
        }

        System.out.print("\nStack2 :- ");
        temp = top2;
        while(temp < size){
            System.out.print(arr[temp] + " ");
            temp++;
        }
    }

    public static void main(String[] args) {
        P52_Two_stacks_in_an_array s = new P52_Two_stacks_in_an_array(5);

        s.push1(3);
        s.push1(5);
        s.push1(4);
        s.push1(34);
        s.push1(8754);
        s.pop1();
        s.push2(64);
        s.pop2();
        s.print();
    }
}
