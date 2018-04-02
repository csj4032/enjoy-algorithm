#import <stdio.h>

char rps[] = "RPS";

int main()
{
  int t;
  for (scanf("%d",&t); t--;) {
    int n;
    int win = 0;
    for (scanf("%d", &n); n--;) {
      char a,b;
      scanf(" %c %c", &a, &b);
      int temp = a-b;
      if(temp==1||temp==2||temp==-3)
				win++;
			else if(temp==0)
				continue;
			else
				win--;
    }

    if(win>0)
      printf("Player 2\n");
    else if(win<0)
      printf("Player 1\n");
    else
      printf("TIE\n");
    }
}
