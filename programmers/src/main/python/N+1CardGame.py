# 카드가 뽑이는 시점에 라운드 성공 여부를 필히 판단 할 필요는 없고 카드가 N+1를 만들 수 있는 시점에 코인 및 카드 뭉치가 남아 있는지 확인

def solution(coin, cards):
    answer = 0
    cards_length = len(cards)
    index = int(cards_length / 3)
    buckets = [0] * 1001
    player_cards = []

    for i in range(index):
        player_cards.append(cards[i])
        buckets[cards[i]] = 1

    while True:
        answer += 1
        if index >= cards_length - 1:
            break
        buckets[cards[index]] = 2
        buckets[cards[index + 1]] = 2
        player_cards.append(cards[index])
        player_cards.append(cards[index + 1])
        index += 2
        result = checked(0, cards_length, player_cards, coin, buckets)
        if result:
            continue
        if coin > 0:
            result = checked(1, cards_length, player_cards, coin, buckets)
            if result:
                coin -= 1
                continue
            result = checked(2, cards_length, player_cards, coin, buckets)
            if result:
                coin -= 2
                continue
        if not result:
            break

    return answer


def checked(flag, cards_length, player_cards, coin_count, buckets):
    for player_card in player_cards:
        if buckets[player_card] == 0:
            continue
        if buckets[(cards_length + 1) - player_card] != 0:
            if flag == 0:
                if (buckets[(cards_length + 1) - player_card] != 1) or (buckets[player_card] != 1):
                    continue
                buckets[player_card] = 0
                buckets[(cards_length + 1) - player_card] = 0
                player_cards.remove(player_card)
                player_cards.remove((cards_length + 1) - player_card)
                return True
            elif flag == 1:
                if (((buckets[(cards_length + 1) - player_card] == 1) and (buckets[player_card] == 2) and (coin_count >= 1))
                        or ((buckets[(cards_length + 1) - player_card] == 2) and (buckets[player_card] == 1) and (coin_count >= 1))):
                    buckets[player_card] = 0
                    buckets[(cards_length + 1) - player_card] = 0
                    player_cards.remove(player_card)
                    player_cards.remove((cards_length + 1) - player_card)
                    return True
            elif flag == 2:
                if (buckets[(cards_length + 1) - player_card] == 2) and (buckets[player_card] == 2) and (coin_count >= 2):
                    buckets[player_card] = 0
                    buckets[(cards_length + 1) - player_card] = 0
                    player_cards.remove(player_card)
                    player_cards.remove((cards_length + 1) - player_card)
                    return True

    return False


solution(3, [1, 6, 7, 2, 3, 10, 5, 9, 8, 12, 11, 4])
