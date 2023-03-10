#include <stdio.h>
#include <stdlib.h>

//TODO PART 2: complete the print_array function to have the right output
//prints out the array in the desired format, for exmaple:
// { 0 1 2 3 4 }
void print_array(int a[], int len){
  printf("{ ");
  for(int i = 0; i < len; i++){
    printf("%d ", a[i]);

  }
  printf("}\n");
  printf("\n");

}

//TODO PART 3: compete the reverse_array function
// hint: you'll need a tmp variable for swaps
void reverse_array(int a[], int len){
  //printf("REVERSING THE ARRAY\n");
  printf("{ ");

  for(int i = len-1; i >= 0; i--){
    printf("%d ", a[i]);
  }
  printf("}\n");
  printf("\n");
}


//TODO PART 4: complete the randomize array function
// hint: random() returns a random number, but you want it to be in
//       the range of the length of the array. Try using modulo
// hint: try randomnly swapping all index with some other index
void randomize_array(int a[], int len){
  //printf("RANDOMIZING THE ARRAY\n");
  
  int temp;
  for(int i = 0; i < len; i++){
    int r = random() % len+1;
    temp = a[r];
    a[r] = a[i];
    a[i] = temp;
  }
  printf("{ ");
  for(int j = 0; j < len; j++){
    printf("%d ", a[j]);
  }
  printf("}\n");
  printf("\n");
}

//TODO PART 5: complete the sort_arry function (smallest to biggest)
// hint: you'll probably need two for loops 
// hint: Check out insertion sort on wikipedia (it's ok to use that source)
void sort_array(int a[],int len){
  printf("SORTING THE ARRAY\n");
}

int main(int argc, char *argv[]){

  int len=0;    //store the length of the array, initially 0 but will change
  int res;      //store the result of scanf() operations
  int choice;   //store the user choice for operations
  //int i;     


  srandom(1992);//seed random number generator


  //TODO PART 1: Requst how many numbers
  // hint: don't forget to return 1 on error

  //int a;
  printf("Enter the length:\n");
  res = scanf("%d", &len);
  if(res == 0){
    printf("ERROR: Invalid input\n");
    return 1;
  }

  

 // printf(res);
  int array[len]; //declare array now that we know its size


  printf("Enter %d numbers (space separated):\n",len);

  //TODO PART 1: Read in desired numbers
  // hint: don't forget to return 1 on error

  //int num;

  for(int i = 0; i < len; i++){
    int x = scanf("%d", &array[i]);
    if(x == 0){
      printf("ERROR: Invalid input\n");
      return 1;
    }
  }
  





  //while loop for operations, run until exit or EOF
  while(1){
    printf("Choose an operation:\n");
    printf("(0) : exit\n");
    printf("(1) : print array\n");
    printf("(2) : reverse array\n");
    printf("(3) : randomize array\n");
    printf("(4) : sort array\n");
    res = scanf("%d",&choice);

    //error check
    if(res == 0){
      char c;
      printf("ERROR: Invalid input. Choose again.\n");

      scanf("%c",&c);//clear stdin and continue
      continue;
    }else if(res == EOF){
      break;
    }

    //TODO: Complete funcation calls based on user choice
    //      - Properly use an if/else if/else block (or a case switch)
    //  
    //      - Each choice should call the appropriate function: 
    //      - print_array(), reverse_array(), randomize_array(), sort_array()
    //
    //      - Remember arrays and pointers in ways are the same, so you can
    //        pass a pointer to the array, as an argument.
    //
    //      - Because you don't know length ahead of time, you'll also need
    //        to pass the length of the array as an argument
    //
    //      - Refresh your memory on loop control, e.g., break and continue

    if (choice == 0){
      break;
    } //add more else if blocks for other choices, e.g., 1, 2, 3, and 4
    else if(choice == 1){
      print_array(array, len);
    }

    else if(choice == 2){
      reverse_array(array, len);
    }
    else if(choice == 3){
      randomize_array(array,len);
    }
    else{
      printf("ERROR: Invalid number. Choose again.\n\n");
      continue;
    }

    
    
  }
  return 0; //return 0 on success

}
