import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
        
    try :
        while scoville[0] < K:
            a = heapq.heappop(scoville)
            b = heapq.heappop(scoville)
            heapq.heappush(scoville, a + b*2)
            answer+=1
    except :
        return -1

    return answer