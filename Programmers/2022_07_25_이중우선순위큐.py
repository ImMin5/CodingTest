import heapq


queue = []
heapq.heapify(queue)

def solution(operations):
    for cmd in operations :
        if cmd[0] == 'I':
            put(int(cmd[2:]))
        elif cmd[0] == 'D' :
            if cmd[2:] == '-1':
                pop('min')
            elif cmd[2:] == '1':
                pop('max')
    if queue.__len__() == 0:
        return [0,0]
    
    answer = [heapq.nlargest(1,queue)[0], heapq.nsmallest(1,queue)[0]]
    
    return answer

def pop(size):
    global queue
    if queue.__len__() == 0 :
        return
    elif queue.__len__() == 1 :
        heapq.heappop(queue)
    elif size == 'max':
        queue = heapq.nsmallest(queue.__len__()-1,queue)
        heapq.heapify(queue)
    elif size == 'min':
        heapq.heappop(queue)
        

def put(num):
    heapq.heappush(queue, num)