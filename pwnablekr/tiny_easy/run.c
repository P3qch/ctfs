#include <unistd.h>

int main(int argc, char** argv)
{
    // char* argv[] = {"AAAA", "BBBB", "CCCC",0};
    execve("./tiny_easy", &argv[1], NULL);
}