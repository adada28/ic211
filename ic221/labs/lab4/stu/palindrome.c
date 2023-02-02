#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int check1(char * str);
int check2(char * str1);

int check1(char *str){
  //TODO: Complete by iterating from front-to-back and back-to-front
  //      to check for a palindrome
  int wordlen = strlen(str);
  char* backword = (char*) malloc(wordlen*sizeof(char));
  printf("%d ", wordlen);
  int j = 0;
  for(int i = wordlen-1; i >= 0; i--){
    backword[j] = str[i];
  }

  //printf("%c ", backword[0]);
  for(int a = 0; a < wordlen; a++){
    printf("%c", backword[a]);
  }
  int pal = 0;
  int x = 1;
  if(backword[0] == str[0]){
    pal = 1;
  }

  while(pal && x > wordlen){
    if(backword[x] == str[1]){
      pal = 1;
    }
    else{
      pal = 0;
    }
  }

  return pal;
  
}

/*
int check2(char *str1){
  char str2[1024]; //string to copy to

  //TODO: Complete by copying str1 to str2, backwards, and then
  //      checking that str1 and str2 are the equal using strcmp()

  //return 1;

}
*/
int main(int argc, char * argv[]){

  char str[1024];

  printf("Enter a string:\n");

  scanf("%1023s",str);

  if(check1(str)){
    printf("Palindrome according to check 1\n");
  }else{
    printf("NOT a palindrome according to check 1\n");
  }
   
/*
  if(check2(str)){
    printf("Palindrome according to check 2\n");
  }else{
    printf("NOT a palindrome according to check 2\n");
  }
*/
}
