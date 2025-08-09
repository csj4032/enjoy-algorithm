package p1700;

import java.util.*;

/**
 * 제목 : 멀티탭 스케줄링 - Optimal Caching (Furthest in Future)
 * 링크 : https://www.acmicpc.net/problem/1700
 * 분류 : 그리디 알고리즘, 스케줄링
 * 난이도 : Gold I
 * 
 * ========================================================================
 * ■ 문제 개요 및 핵심 개념
 * ========================================================================
 * 
 * N개의 구멍이 있는 멀티탭과 K개의 전기용품 사용 순서가 주어질 때,
 * 플러그를 뽑는 횟수를 최소화하는 문제입니다.
 * 
 * ★ 핵심 아이디어:
 * - 캐시 교체 알고리즘 중 "Furthest in Future" 전략 사용
 * - 멀티탭에 빈 자리가 있으면 그냥 꽂기
 * - 빈 자리가 없으면, 가장 나중에 사용되거나 더 이상 사용되지 않는 전기용품을 제거
 * 
 * ★ 알고리즘:
 * 1) 현재 전기용품이 이미 멀티탭에 있으면 continue
 * 2) 멀티탭에 빈 자리가 있으면 꽂기
 * 3) 빈 자리가 없으면:
 *    - 각 멀티탭의 전기용품이 다음에 언제 사용되는지 확인
 *    - 가장 나중에 사용되거나 더 이상 사용되지 않는 것을 제거
 * 
 * 시간복잡도: O(N×K) - 각 전기용품마다 멀티탭 전체 확인
 * 공간복잡도: O(N+K)
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 멀티탭 구멍 수
        int K = sc.nextInt(); // 전기용품 사용 횟수
        
        int[] schedule = new int[K];
        for (int i = 0; i < K; i++) {
            schedule[i] = sc.nextInt();
        }
        
        Set<Integer> multitap = new HashSet<>();
        int unplugCount = 0;
        
        for (int i = 0; i < K; i++) {
            int current = schedule[i];
            
            // 이미 멀티탭에 꽂혀있으면 continue
            if (multitap.contains(current)) {
                continue;
            }
            
            // 멀티탭에 자리가 있으면 그냥 꽂기
            if (multitap.size() < N) {
                multitap.add(current);
                continue;
            }
            
            // 멀티탭이 가득 찬 경우 - 하나를 뽑아야 함
            int toRemove = findDeviceToRemove(multitap, schedule, i);
            multitap.remove(toRemove);
            multitap.add(current);
            unplugCount++;
        }
        
        System.out.println(unplugCount);
    }
    
    /**
     * 제거할 전기용품을 찾는 함수 (Furthest in Future 전략)
     */
    private static int findDeviceToRemove(Set<Integer> multitap, int[] schedule, int currentIndex) {
        int deviceToRemove = -1;
        int furthestIndex = -1;
        
        for (int device : multitap) {
            int nextUseIndex = findNextUse(schedule, currentIndex + 1, device);
            
            // 더 이상 사용되지 않는 경우 (가장 우선적으로 제거)
            if (nextUseIndex == -1) {
                return device;
            }
            
            // 가장 나중에 사용되는 전기용품 찾기
            if (nextUseIndex > furthestIndex) {
                furthestIndex = nextUseIndex;
                deviceToRemove = device;
            }
        }
        
        return deviceToRemove;
    }
    
    /**
     * 특정 전기용품이 다음에 언제 사용되는지 찾는 함수
     */
    private static int findNextUse(int[] schedule, int startIndex, int device) {
        for (int i = startIndex; i < schedule.length; i++) {
            if (schedule[i] == device) {
                return i;
            }
        }
        return -1; // 더 이상 사용되지 않음
    }
}