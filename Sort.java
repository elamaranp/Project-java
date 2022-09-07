class Sort {
    static void bubbleSort(int arrayToBeSorted[], int n){
        if (n == 1){
            return;                  //return if we encounter n == 1
        }
        for (int i=0; i<n-1; i++){
            if (arrayToBeSorted[i] > arrayToBeSorted[i+1]) {
                int temp = arrayToBeSorted[i];
                arrayToBeSorted[i] = arrayToBeSorted[i+1]; //Assigning
                arrayToBeSorted[i+1] = temp;
            }
        }
        bubbleSort(arrayToBeSorted, n-1);
    }
    void display(int arrayToBeSorted[]) {  //display the array elements
        for (int i=0; i<arrayToBeSorted.length; ++i){
            System.out.print(arrayToBeSorted[i]+" ");
        }
    }

    public static void main(String[] args) {
        Sort sortObject= new Sort();
        int arrayToBeSorted[] = {18, 14, 5, 12, 2, 11, 9};
        bubbleSort(arrayToBeSorted, arrayToBeSorted.length);
        sortObject.display(arrayToBeSorted);
    }
}