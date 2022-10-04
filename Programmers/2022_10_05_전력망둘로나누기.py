#https://school.programmers.co.kr/learn/courses/30/lessons/86971

from collections import deque

def solution(n, wires):
    answer = 101
    wire_map = [[] for i in range(0, n+1)]
    
            
    # 네트워크망 표시
    for x, y in wires:
        wire_map[x].append(y)
        wire_map[y].append(x)
    
    
    for d_x, d_y in wires:
        wire_map[d_x].remove(d_y)
        wire_map[d_y].remove(d_x)
        
        count = get_network(wire_map, d_x, n)
        answer = min(answer, abs(count-(n-count)))
        wire_map[d_x].append(d_y)
        wire_map[d_y].append(d_x)
        
    return answer

def get_network(wire_map, start_node, n):
    visited = [False] * (n+1)
    queue = deque()
    queue.append(start_node)
    visited[start_node] = True
    count = 1
    
    while queue :
        node = queue.pop()
        for _node in wire_map[node]:
            if visited[_node] == False :
                queue.append(_node)
                visited[_node] = True
                count += 1
    return count