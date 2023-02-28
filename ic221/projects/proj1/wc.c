#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int wordcount(char c, char prevchar, int wcount);
int charcount(char c, int ccount);
int linecount(char c, int lcount);

int wordcount(char c, char prevchar, int wcount){
    int chwhitespace = isspace(c);
    int prevcharwhitespace = isspace(prevchar); 
    if(chwhitespace == 0 && prevcharwhitespace != 0){
        wcount++;            
    }
    return wcount;    
}

int charcount(char c, int ccount){
    ccount++;
    return ccount;
}


int linecount(char c, int lcount){
    if(c == '\n'){
        lcount++;            
    }
    return lcount;    
}

int main(int argc, char * argv[]){
    FILE * file = fopen(argv[1], "r");
    int words=0;
    int lines = 0;
    int chars=0;
    char prevchar = ' ';
    while(!feof(file)){
        char c = fgetc(file);
        words = wordcount(c, prevchar, words);
        chars = charcount(c, chars);
        lines = linecount(c, lines);
        prevchar = c;
    }

    printf("%s %d %d %d \n", argv[1], lines, words, chars);

    fclose(file);

    return 0; 
}