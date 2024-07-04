#include <stdio.h>
#include <stdint.h>
#include <unistd.h>
//#include "flag.h"
#define FLAG "this is the flag!!!!!!!"


// color macros for printf
// thanks: https://stackoverflow.com/questions/1961209/making-some-text-in-printf-appear-in-green-and-red
#define RESET   "\033[0m"
#define RED     "\033[31m"      /* Red */
#define GREEN   "\033[32m"      /* Green */

// general terms
#define TRUE 1
#define FALSE 0
#define NO_DISK 0xffffffff

// game properties
#define NUM_OF_DISKS 64
#define NUM_OF_RODS 3

struct disk
{
	uint32_t rod_mask;
};
struct disk disks[NUM_OF_DISKS];

// put all disks on rod 0
void init(void)
{
	for (uint32_t i = 0; i < NUM_OF_DISKS; i++)
	{
		disks[i].rod_mask = (1 << 0);
	}
}

// check if all disks are on the last rod
// (the last rod is rod number 2 when starting to count from 0)
// return TRUE if win and FALSE if fail
uint32_t check_win(void)
{
	uint32_t rods_res = 0;
	for (uint32_t i = 0; i < NUM_OF_DISKS; i++)
	{
		rods_res |= disks[i].rod_mask;
	}

	// check if all the rods are empty except from the last
	for (uint32_t rod = 0; rod < NUM_OF_RODS - 1; rod++)
	{
		if ((rods_res & (1 << rod)) != 0) return FALSE;
	}
	if ((rods_res & (1 << (NUM_OF_RODS-1))) != 0) return TRUE;
	return FALSE;
}

// return the top disk on the given rod
// if the rod is empty return NO_DISK
uint32_t get_top_disk(uint32_t rod)
{
	uint32_t disk;
	for (disk = 0; disk < NUM_OF_DISKS; disk++)
	{
		// the first disk we found on rod is the top one
		if (disks[disk].rod_mask & (1 << rod)) return disk;
	}
	return NO_DISK; // no disk on rod

}

uint32_t is_move_valid(uint8_t disk, uint8_t rod)
{
	if (rod >= NUM_OF_RODS) return FALSE;

	// for each disk on the given rod check that the given disk is smaller
	for (uint8_t i = 0; i < NUM_OF_DISKS; i++)
	{
		if ((disks[i].rod_mask & (1 << rod)) && (disk > i))
			return FALSE;
	}
	return TRUE; // all the disks on the rod are larger then the given disk
}

// move the top disk in the given rod to the right
uint32_t move_top_disk_right(uint8_t rod, uint8_t right)
{
	// check validity of parameters
	if (rod >= NUM_OF_RODS) return FALSE; //check rod is in range
	if (rod - right > rod) return FALSE;   //check int overflow for dest rod
	uint8_t dest_rod = rod - right;
	if (dest_rod >= NUM_OF_RODS) return FALSE; // check dest rod is in range

	// take the top disk
	uint32_t disk = get_top_disk(rod);
	if (disk == NO_DISK) return FALSE;

	// and move it to the requested rod if possible
	 if (!is_move_valid(disk, dest_rod)) return FALSE;
	disks[disk].rod_mask >>= right;
	return TRUE;
}

// move the top disk in the given rod to the left
uint32_t move_top_disk_left(uint8_t rod, uint8_t left)
{
	// check validity of parameters
	if (rod >= NUM_OF_RODS) return FALSE; //check rod is in range
	if (rod + left < rod) return FALSE;   //check int overflow for dest rod
	uint8_t dest_rod = rod + left;
	if (dest_rod >= NUM_OF_RODS) return FALSE; // check dest rod is in range

	// take the top disk
	uint32_t disk = get_top_disk(rod);
	if (disk == NO_DISK) return FALSE;

	// and move it to the requested rod if possible
	 if (!is_move_valid(disk, dest_rod)) return FALSE;
	disks[disk].rod_mask <<= left;
	return TRUE;
}

void print_disks_on_rods(void)
{
	for (uint32_t rod = 0; rod < NUM_OF_RODS; rod++)
	{
		printf("%d|", rod+1);
		for (int disk = NUM_OF_DISKS-1; disk >= 0; disk--)
		{
			if (disks[disk].rod_mask & (1 << rod))
			{
				printf("%d,", disk);
			}
		}
		printf("\n\n");
	}
}

int main(void)
{
	uint32_t orig_rod;
	uint32_t dest_rod;

	setbuf(stdout, NULL);

	printf("Welcome to the Tower of Annoy!!\n");
	printf("They say it should take the monks 580 billion years or something to solve.\n");
	printf("But I'm sure you'll do it in no time :)\n\n\n");

	init();
	while (TRUE)
	{
		if (check_win())
		{
			printf("Yay! I knew you have it!\n");
			printf("take your flag: ");
			printf(GREEN FLAG RESET);
			printf("\n");
			break;
		}
		print_disks_on_rods();
		printf("From which rod do you want to move a disk? (1-3): ");
		scanf("%u", &orig_rod);
		orig_rod--; // map rod range to (0-2)
		printf("To which rod do you want to move the disk? (1-3): ");
		scanf("%u", &dest_rod);
		dest_rod--; // map rod range to (0-2)
		if (orig_rod < dest_rod)
		{
			// move left
			if (move_top_disk_left(orig_rod, dest_rod - orig_rod) == FALSE)
			{
				printf(RED "\nERROR: Can't perform that move :(\n\n" RESET);
				continue;
			}
		}
		else if (orig_rod > dest_rod)
		{
			// move right
			if (move_top_disk_right(orig_rod, orig_rod - dest_rod) == FALSE)
			{
				printf(RED "\nERROR: Can't perform that move :(\n\n" RESET);
				continue;
			}
		}
		sleep(1);
		printf("Here you go:\n");
	};
	return 0;
}
