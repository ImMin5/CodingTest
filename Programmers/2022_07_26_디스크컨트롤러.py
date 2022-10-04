
def solution(jobs):
    answer = 0
    time = 0
    job_index = 0
    works = []
    works_complete = 0
    
    #시간순으로 정렬
    jobs.sort()
    
    while works_complete < jobs.__len__() :
        
        while job_index < jobs.__len__() and time >= jobs[job_index][0] :
            #처리해야할 work의 기준을 소요시간으로 변경
            works.append([jobs[job_index][1],jobs[job_index][0]])
            job_index += 1
        
        works.sort()
        
        if works.__len__() == 0 :
            time = jobs[job_index][0]
        else :
            answer += works[0][0] + (time - works[0][1])
            time += works[0][0]
            works_complete += 1
            del works[0]
            
    return int(answer/works_complete)