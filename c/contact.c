#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include <signal.h>

#define MAX_NAME_LENGTH 50
#define MAX_PHONE_LENGTH 20
#define MAX_CONTACTS 100
#define FILENAME "contracts.txt"

typedef struct Contact{
    char name[MAX_NAME_LENGTH];
    char phone[MAX_PHONE_LENGTH];
} Contact;

Contact contacts[MAX_CONTACTS];
int contact_count =0;

void load_contacts();
void save_contacts();
void add_contacts();
void view_contacts();
void search_contacts();
void delete_contacts();
void menu();
void shutdown();

int main() {
    if (atexit(save_contacts) != 0) {
        printf("Error setting up exit function.\n");
        exit(1);
    }
    signal(SIGINT, shutdown);
    load_contacts();
    menu();
    return 0;
}

void shutdown()
{
    save_contacts();
    exit(0);
}

void load_contacts()
{
    FILE *file = fopen(FILENAME, "r");
    if (file == NULL) {
        // no file to read
        return;
    }
    while (fscanf(file, "%s %s", contacts[contact_count].name, contacts[contact_count].phone) !=EOF) {
        contact_count++;
    }
    fclose(file);
}

void save_contacts()
{
    FILE *file = fopen(FILENAME, "w");
    if (file == NULL) {
        printf("Error saving contacts.\n");
    }
    int i;
    for (i=0; i< contact_count; i++) {
        fprintf(file, "%s %s\n", contacts[i].name, contacts[i].phone);
    }
    fclose(file);
}

void add_contacts()
{
    if (contact_count >= MAX_CONTACTS) {
        printf("Contact list is full \n");
    }
    printf("Enter name: ");
    scanf("%s", contacts[contact_count].name);
    printf("Enter phone: ");
    scanf("%s", contacts[contact_count].phone);
    contact_count++;
    printf("Contact added successfully.\n");
}

void view_contacts()
{
    int i;
    for (i=0; i < contact_count; i++) {
        printf("Name: %s, Phone: %s\n", contacts[i].name, contacts[i].phone);
    }
}

void search_contacts()
{
    int i;
    char query[MAX_NAME_LENGTH];
    printf("Enter name or phone to search: ");
    scanf("%s", query);
    for (i=0; i<contact_count; i++) {
        if (strcmp(contacts[i].name, query) ==0 || strcmp(contacts[i].phone, query) == 0) {
            printf("Found: Name: %s, Phone: %s\n", contacts[i].name, contacts[i].phone);
            return;
        }
    }
    printf("Contact not found\n");
}

void delete_contacts()
{
    int i, j;
    char query[MAX_NAME_LENGTH];
    printf("Enter name or phone to delete: ");
    scanf("%s", query);
    for (i=0; i < contact_count; i++) {
        if (strcmp(contacts[i].name, query) ==0 || strcmp(contacts[i].phone, query) == 0) {
            for (j = i; j < contact_count -1; j++) {
                contacts[j] = contacts[j+1];
            }
            contact_count--;
            printf("Contact deleted successfully.\n");
            return;
        }
    }
    printf("Contact not found\n");
}

void menu()
{
    int choice;
    do {
        printf("\n--- Address Book Service ---\n");
        printf("1. Add conatact \n");
        printf("2. View contact \n");
        printf("3. Search contact \n");
        printf("4. Delete contact \n");
        printf("5. Exit \n");
        printf("input choose: ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            add_contacts();
            break;
        case 2:
            view_contacts();
            break;
        case 3:
            search_contacts();
            break;
        case 4:
            delete_contacts();
            break;
        case 5:
            printf("Existing program.\n");
            break;
        default:
            printf("Invalid choice. Try again.\n");
            break;
        }

    } while (choice != 5);
}