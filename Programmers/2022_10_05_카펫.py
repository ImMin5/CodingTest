#https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=python3

def solution(brown, yellow):
    answer = []
    sum = brown + yellow
    h = 3 # height의 최솟값
    w = int((brown+yellow)/h) # width의 최댓값 

    for _w in range(w,2,-1) :
        _h = sum/_w
        if _w*_h == sum and (_w-2)*(_h-2) == yellow: # 종료 조건
            answer.append(_w)
            answer.append(_h)
            break

    return answer