class Sort {
    static void bubbleSort(int arr[], int n)
    {
        if (n == 1){
            return;
        }
        for (int i=0; i<n-1; i++){
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1]; //Assigning
                arr[i+1] = temp;  //act
            }
        }
        bubbleSort(arr, n-1);
    }
    void display(int arr[]) {
        for (int i=0; i<arr.length; ++i){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Sort ob = new Sort();
        int arr[] = {18, 14, 5, 12, 2, 11, 9};
        bubbleSort(arr, arr.length);
        ob.display(arr);
    }
}