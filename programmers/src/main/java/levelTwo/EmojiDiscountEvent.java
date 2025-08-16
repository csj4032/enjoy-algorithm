package levelTwo;

import java.util.Arrays;

/**
 * Link: <a href="https://programmers.co.kr/learn/courses/30/lessons/131127">...</a>
 * Category: 완전탐색, Brute Force
 * Describe: 이모티콘 할인행사
 */
public class EmojiDiscountEvent {

    int[] discountRates = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        int maxSubscribers = 0;
        int maxRevenue = 0;
        int emoticonCount = emoticons.length;
        int totalCombinations = (int) Math.pow(discountRates.length, emoticonCount);
        for (int i = 0; i < totalCombinations; i++) {
            int[] currentDiscounts = new int[emoticonCount];
            int temp = i;
            for (int j = 0; j < emoticonCount; j++) {
                currentDiscounts[j] = discountRates[temp % discountRates.length];
                temp /= discountRates.length;
            }
            System.out.println("Current Discounts: " + Arrays.toString(currentDiscounts) + " for combination: " + i);

            int totalRevenue = 0;
            int subscribers = 0;

            for (int[] user : users) {
                int userThreshold = user[0];
                int userBudget = user[1];
                int userTotalCost = 0;

                for (int j = 0; j < emoticonCount; j++) {
                    int discountedPrice = emoticons[j] * (100 - currentDiscounts[j]) / 100;
                    if (currentDiscounts[j] >= userThreshold) userTotalCost += discountedPrice;
                }

                if (userTotalCost >= userBudget) {
                    subscribers++;
                } else {
                    totalRevenue += userTotalCost;
                }
            }

            if (subscribers > maxSubscribers || (subscribers == maxSubscribers && totalRevenue > maxRevenue)) {
                maxSubscribers = subscribers;
                maxRevenue = totalRevenue;
            }
        }
        return new int[]{maxSubscribers, maxRevenue};
    }
}
