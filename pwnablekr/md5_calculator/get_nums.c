/*
COMPILE WITH: gcc get_nums.c -o get_nums -m32
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    srand(time(NULL));
    
    printf("%d %d %d %d %d %d %d %d\n", rand(), rand(), rand(), rand(), rand(), rand(), rand(), rand());
    return 0;
}