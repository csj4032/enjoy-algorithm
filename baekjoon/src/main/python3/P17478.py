{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "cd0d92a4-39e1-48f1-b571-d94175ece0a8",
   "metadata": {},
   "outputs": [],
   "source": [
    "def recursive(step, last_step):\n",
    "    print('____' * step + '\"재귀함수가 뭔가요?\"')\n",
    "    print('____' * step + '\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.')\n",
    "    print('____' * step + '마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.')\n",
    "    print('____' * step + '그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"')\n",
    "    if(step == last_step-1):\n",
    "        print('____' * (step+1) + '\"재귀함수가 뭔가요?\"')\n",
    "        print('____' * (step+1) + '\"재귀함수는 자기 자신을 호출하는 함수라네\"')\n",
    "        print('____' * (step+1) + '라고 답변하였지.')\n",
    "    if(step < last_step-1):\n",
    "        recursive(step+1, last_step)\n",
    "    print('____' * step + '라고 답변하였지.')\n",
    "    \n",
    "n = int(input())\n",
    "print('어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.')\n",
    "recursive(0, n)"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.8.10"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
