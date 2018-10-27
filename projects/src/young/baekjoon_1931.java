package young;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * 문제번호 : 1931번
 * 문제제목 : 회의실 배정 
 * 작 성 자 : Ryan Yun
 * 
 * 문제내용 : 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다. 
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 
 * 최대수의 회의를 찾아라. 
 * 
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
 * 회의의 시작 시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * 입   력 : 첫째 줄에 회의의 수 N(1 <= N <= 100,000)이 주어진다. 
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 시작 시간과 끝나는 시간은 2^31-1 보다 작거나 같은 자연수 또는 0 이다.
 * 
 * 출   력 : 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 * 
 * 풀이방법 : 끝나는 시간을 기준으로 회의를 오름차순으로 정렬한 다음 그리디 알고리즘을 사용하여 문제를 풀 수 있다,.
 * 끝나는 시간이 같다면 시작 시간이 빠른 것을 우선으로 한다. 
 */
public class baekjoon_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int meetingNum = sc.nextInt();	// 회의 개수
		Vector<Meeting> meetings = new Vector<Meeting>(meetingNum);
		// Meeting = (시작시간, 종료시간)
		
		for(int i = 0; i < meetingNum; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();
			meetings.add(new Meeting(startTime, endTime));
		}
		
		Collections.sort(meetings); // 회의시간이 짧은 순으로 앞으로 정렬함
		
		countMeeting(meetingNum, meetings);
		
		sc.close();
		
	}

	private static void countMeeting(int meetingNum, Vector<Meeting> meetings) {
		int count = 0;
		int endTime = 0;
		
		for(int i = 0; i < meetingNum; i++) {
			Meeting meeting = meetings.get(i);
			if(meeting.getStartTime() >= endTime) {
				count++;
				endTime = meeting.getEndTime();
			}
		}
		
		System.out.println(count);
	}
}

class Meeting implements Comparable<Meeting> {
	
	private int startTime;
	private int endTime;
	
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	@Override
	public int compareTo(Meeting meeting) { // compareTo : 2개의 두 문자열을 비교하고 int 형 값을 반환하는 메소
		if(this.endTime < meeting.getEndTime()) {
			return -1;
		}else if(this.endTime == meeting.getEndTime()) {
			if(this.startTime < meeting.getStartTime()) {
				return -1;
			} else if(this.startTime == meeting.getStartTime()) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}
