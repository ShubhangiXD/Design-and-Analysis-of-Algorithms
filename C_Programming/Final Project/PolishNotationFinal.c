#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>

#define MAX_LEN 2048
char EXP[MAX_LEN];
char stack[MAX_LEN];
int flag = 0;
int top = -1;

int isEmpty()
{
    if (top == -1)
        return 1;
    else
        return 0;
}

int isFull()
{
    if (top == MAX_LEN)
        return 1;
    else
        return 0;
}

char popDigit()
{
    char data;
    if (!isEmpty())
    {
        data = stack[top];
        top = top - 1;
        return data;
    }
    else
    {
        printf("Could not retrieve data, Stack is empty.\n");
    }
}

void toStack(char data)
{
    if (!isFull())
    {
        top = top + 1;
        stack[top] = data;
    }
    else
    {
        printf("Stack Overflow.\n");
    }
}

void pushStack(char *expression)
{
    for (int i = strlen(EXP) - 1; i >= 0; i--)
    {
        // toStack(EXP[i]);
        signed char symbol = EXP[i];
        if (symbol >= 97 && symbol <= 122) // letter
        {
            toStack(symbol);
            flag = 0;
            //printf("letter, flag: %d\n", flag);
        }
        else if (symbol >= 48 && symbol <= 57) // digit
        {
            toStack(symbol);
            flag = flag + 1;
            //printf("digit, flag: %d\n", flag);
        }
        else if (symbol == '+' || symbol == '-' || symbol == '*')
        {
            if (flag >= 2)
            {
                int o1 = (int)popDigit() - '0';
                int o2 = (int)popDigit() - '0';
                int result = 0;
                switch (symbol)
                {
                case '+':
                    result = o1 + o2;
                    break;
                case '-':
                    result = o1 - o2;
                    break;
                case '*':
                    result = o1 * o2;
                    break;
                default:
                    printf("Invalid expression.");
                    break;
                }
                //printf("%d\n", result);
                char res = result + '0';
                //printf("%c\n", res);
                toStack(res);
                flag = flag - 1;
            }
            else
            {
                toStack(symbol);
                flag = 0;
                //printf("operator, flag: %d\n", flag);
            }
        }
    }
}

void displayStack()
{
    while (!isEmpty())
    {
        char data = popDigit();
        printf("%c ", data);
    }
}

int main()
{
    printf("Enter the polish notation to simplify: ");
    gets(EXP);
    pushStack(EXP);
    printf("The simplified expression is: ");
    displayStack();
    return 0;
}