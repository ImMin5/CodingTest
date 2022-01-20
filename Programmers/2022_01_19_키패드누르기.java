//https://programmers.co.kr/learn/courses/30/lessons/67256?language=java#

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        int leftIdx = 10;
        int rightIdx = 12;
        String answer = "";
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                 leftIdx = number;
                answer = answer.concat("L");
            }
            else if(number == 3 || number == 6 || number == 9){
                rightIdx = number;
                answer = answer.concat("R");
            }
            else{
                if(number == 0) number = 11;
                
                // 처음 위치일 경우 *,#
                if(leftIdx == 10 && rightIdx == 12){
                    if(hand.equals("left") == true){
                        leftIdx = number;
                        answer = answer.concat("L");
                    }
                    else if(hand.equals("right") == true) {
                        rightIdx = number;
                        answer = answer.concat("R");
                    }
                        
                }
                else{
                    int x ,y;
                    int leftX,leftY;
                    int rightX, rightY;
                    x = (number-1)%3;
                    y = (number-1)/3;
                    
                    leftX = (leftIdx-1)%3;
                    leftY = (leftIdx-1)/3;
                    
                    rightX = (rightIdx-1)%3;
                    rightY = (rightIdx-1)/3;
                    
                    if(getDistance(x,y,leftX,leftY) < getDistance(x,y,rightX,rightY)){
                        leftIdx = number;
                        answer = answer.concat("L");
                    }
                    else if(getDistance(x,y,leftX,leftY) > getDistance(x,y,rightX,rightY)){
                        rightIdx = number;
                        answer = answer.concat("R");
                    }
                    else{
                        if(hand.equals("left") == true){
                            leftIdx = number;
                            answer = answer.concat("L");
                        }
                        else {
                            rightIdx = number;
                            answer = answer.concat("R");
                        }
                    }
                    
                    
                }
            }
        }
        return answer;
    }
    private int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}